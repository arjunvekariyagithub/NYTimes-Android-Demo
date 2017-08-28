package com.mfp.test.ui.search;

import com.mfp.test.di.PerActivity;
import com.mfp.test.ui.base.MvpPresenter;

@PerActivity
public interface SearchMvpPresenter<V extends SearchMvpView> extends MvpPresenter<V> {

    void fetchNewsArticles(String term, int page);
}
