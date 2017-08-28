package com.mfp.test.di.module;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.mfp.test.R;
import com.mfp.test.data.network.model.Doc;
import com.mfp.test.di.ActivityContext;
import com.mfp.test.di.PerActivity;
import com.mfp.test.ui.details.DetailsMvpPresenter;
import com.mfp.test.ui.details.DetailsMvpView;
import com.mfp.test.ui.details.DetailsPresenter;
import com.mfp.test.ui.search.NewsListAdapter;
import com.mfp.test.ui.search.SearchMvpPresenter;
import com.mfp.test.ui.search.SearchMvpView;
import com.mfp.test.ui.search.SearchPresenter;
import com.mfp.test.utils.rx.AppSchedulerProvider;
import com.mfp.test.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SearchMvpPresenter<SearchMvpView> provideSearchPresenter(
            SearchPresenter<SearchMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DetailsMvpPresenter<DetailsMvpView> provideDetailsPresenter(
            DetailsPresenter<DetailsMvpView> presenter) {
        return presenter;
    }

    @Provides
    NewsListAdapter provideNewsListAdapter(AppCompatActivity activity) {
        return new NewsListAdapter(new ArrayList<Doc>());
    }

    @Provides
    StaggeredGridLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new StaggeredGridLayoutManager(activity.getResources().getInteger(R.integer.column_cnt), 1);
    }
}
