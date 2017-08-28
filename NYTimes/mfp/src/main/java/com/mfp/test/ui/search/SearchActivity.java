package com.mfp.test.ui.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.mfp.test.R;
import com.mfp.test.data.network.model.Doc;
import com.mfp.test.ui.EndlessRecyclerViewScrollListener;
import com.mfp.test.ui.base.BaseActivity;
import com.mfp.test.ui.details.DetailsActivity;
import com.mfp.test.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements SearchMvpView, NewsListAdapter.Callback,
        SearchView.OnQueryTextListener {

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.swipeRefreshLayout)
    public SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    public SearchMvpPresenter<SearchMvpView> mPresenter;

    @Inject
    public NewsListAdapter mNewsAdapter;

    @Inject
    public StaggeredGridLayoutManager mLayoutManager;

    private SearchView mSearchView;

    private Context mContext;

    private String mQuery = "Football";

    private long mTotalPage;

    private long mTotalDocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = this;
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        setTitle(mQuery);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mNewsAdapter.setCallback(this);
        showLoading();
        mPresenter.fetchNewsArticles(mQuery, 0);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.fetchNewsArticles(mQuery, 0);
            }
        });


        mRecyclerView.addOnScrollListener(
                /**
                 * Listener to implement pagination.
                 *
                 * See {@link EndlessRecyclerViewScrollListener}
                 */
                new EndlessRecyclerViewScrollListener(mLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount) {
                        // Triggered only when new data needs to be appended to the list
                        //if (mLayoutManager.getItemCount() < mTotalDocs) {
                            mPresenter.fetchNewsArticles(mQuery, page);
                        //}
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (mSearchView != null && !mSearchView.isIconified()) {
            mSearchView.setQuery("", false);
            mSearchView.setIconified(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mLayoutManager.setSpanCount(mContext.getResources().getInteger(R.integer.column_cnt));
        mNewsAdapter.notifyDataSetChanged();
    }

    @Override
    public void setAdapter(List<Doc> newsItems) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
            showSnackBar(getString(R.string.results_updated));
            mNewsAdapter.clear();
        }
        mNewsAdapter.addItems(newsItems);
        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setAdapter(mNewsAdapter);
        }
    }

    @Override
    public void setDocumentCount(int documentCount) {
        mTotalDocs = documentCount;
        mTotalPage = Math.round(Math.ceil(documentCount / (float)10));
    }

    @Override
    public void onNewsEmptyViewRetryClick() {
        showLoading();
        mPresenter.fetchNewsArticles(mQuery, 0);
    }

    @Override
    public void onNewsArticleClick(Doc doc) {
            Intent intent = new Intent(mContext, DetailsActivity.class);
            intent.putExtra(AppConstants.KEY_WEB_URL, doc.getWebUrl());
            mContext.startActivity(intent);
    }

    private void initSearchMenu(Menu menu) {
            SearchManager manager = (SearchManager) mContext.getSystemService(Context.SEARCH_SERVICE);
            mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
            mSearchView.setQueryHint(getResources().getString(R.string.search_hint));
            mSearchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
            mSearchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mNewsAdapter.clear();
        mQuery = query;
        setTitle(mQuery);
        mPresenter.fetchNewsArticles(query, 0);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_menu, menu);

        initSearchMenu(menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}
