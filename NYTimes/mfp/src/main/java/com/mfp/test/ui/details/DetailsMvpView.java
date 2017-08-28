package com.mfp.test.ui.details;

import com.mfp.test.ui.base.MvpView;

public interface DetailsMvpView extends MvpView {

    // add any search activity specific behaviour if required

    void loadDataInWebView();

    void showErrorView(String error);

    void showErrorView(int resId);

    void hideErrorView();
}
