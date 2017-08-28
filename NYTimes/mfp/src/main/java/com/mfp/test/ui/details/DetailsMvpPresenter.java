package com.mfp.test.ui.details;

import com.mfp.test.di.PerActivity;
import com.mfp.test.ui.base.MvpPresenter;

@PerActivity
public interface DetailsMvpPresenter<V extends DetailsMvpView> extends MvpPresenter<V> {

    void onViewInitialized();
}
