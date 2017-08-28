package com.mfp.test.ui.search;

import com.mfp.test.BuildConfig;
import com.mfp.test.data.DataManager;
import com.mfp.test.data.network.QueryBuilder;
import com.mfp.test.data.network.model.Doc;
import com.mfp.test.data.network.model.SearchResponse;
import com.mfp.test.ui.base.BasePresenter;
import com.mfp.test.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class SearchPresenter<V extends SearchMvpView> extends BasePresenter<V>
        implements SearchMvpPresenter<V> {

    private static final String TAG = "SearchPresenter";

    @Inject
    public SearchPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    /**
     *  fetch news articles from {@link BuildConfig#BASE_URL}
     *
     * @param term search term
     * @param page page number used for pagination
     */

    @Override
    public void fetchNewsArticles(String term, final int page) {
        getCompositeDisposable().add(getDataManager()
                .searchArticles(BuildConfig.API_KEY, term, QueryBuilder.PARAM_SORT ,QueryBuilder.getParamFL(), QueryBuilder.getParamFQ(), page)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<SearchResponse>() {
                    @Override
                    public void accept(@NonNull SearchResponse searchResponse)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        String statusCode = searchResponse.getStatus();

                        List<Doc> news = new ArrayList<Doc>();
                        if (statusCode != null && statusCode.equals("OK")) {
                            news =  searchResponse.getDocuments().getDocs();
                            if (page == 0) {
                                getMvpView().setDocumentCount(searchResponse.getDocuments().getMeta().getHits());
                            }
                        } else {
                            handleApiError(null);
                        }
                        getMvpView().setAdapter(news);
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable t)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        getMvpView().setAdapter(new ArrayList<Doc>());
                        handleApiError(t);
                    }
                }));
    }
}
