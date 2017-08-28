package com.mfp.test.ui.details;

import com.mfp.test.R;
import com.mfp.test.data.DataManager;
import com.mfp.test.ui.base.BasePresenter;
import com.mfp.test.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V>
        implements DetailsMvpPresenter<V> {

    private static final String TAG = "DetailsPresenter";

    @Inject
    public DetailsPresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().showLoading();
            getMvpView().loadDataInWebView();
        } else {
            getMvpView().showErrorView(R.string.error_msg_no_internet);
        }
    }
}
