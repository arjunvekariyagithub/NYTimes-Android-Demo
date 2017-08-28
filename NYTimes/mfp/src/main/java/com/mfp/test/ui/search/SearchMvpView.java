package com.mfp.test.ui.search;

import com.mfp.test.data.network.model.Doc;
import com.mfp.test.ui.base.MvpView;

import java.util.List;

public interface SearchMvpView extends MvpView {

    // add any search activity specific behaviour here

    void setAdapter(List<Doc> newsItems);

    void setDocumentCount(int documentCount);
}
