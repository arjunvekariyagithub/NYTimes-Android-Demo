package com.mfp.test.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mfp.test.R;
import com.mfp.test.ui.base.BaseActivity;
import com.mfp.test.utils.AppConstants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity implements DetailsMvpView {

    private String mCurrentUrl = null;

    @BindView(R.id.web_view)
    public WebView mWebView;

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.error_layout)
    public LinearLayout mErrorLayout;

    @BindView(R.id.error_txt_what)
    public TextView mTextErrorWhat;

    @BindView(R.id.error_txt_cause)
    public TextView mTextError;

    @BindView(R.id.error_btn_retry)
    public Button mRetryButton;

    @Inject
    DetailsMvpPresenter<DetailsMvpView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        setUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void setUp() {
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        mTextErrorWhat.setTextColor(getResources().getColor(R.color.colorBlack));
        mTextErrorWhat.setTextColor(getResources().getColor(R.color.colorBlack));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        mWebView.setWebViewClient(new BrowserClient());


        presenter.onViewInitialized();
    }

    @OnClick(R.id.error_btn_retry)
    void onRetryClick() {
        presenter.onViewInitialized();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, mCurrentUrl);
                startActivity(shareIntent);
                break;
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Manages the behavior when URLs are loaded
    private class BrowserClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            hideLoading();
        }
    }

    @Override
    public void loadDataInWebView() {
        hideErrorView();
        mWebView.loadUrl(getWebUrl());
    }

    @Override
    public void showErrorView(String error) {
        mErrorLayout.setVisibility(View.VISIBLE);
        if (mTextError != null)
            mTextError.setText(error);
        super.onError(error);
    }

    @Override
    public void showErrorView(int resId) {
        showErrorView(getString(resId));
    }

    @Override
    public void hideErrorView() {
        mErrorLayout.setVisibility(View.GONE);
    }

    public String getWebUrl() {
        if (mCurrentUrl == null) {
            Intent i = getIntent();
            mCurrentUrl = i.getStringExtra(AppConstants.KEY_WEB_URL);
        }
        return mCurrentUrl;
    }

    @Override
    protected void onDestroy() {
        mWebView.freeMemory();
        super.onDestroy();
        presenter.onDetach();
    }
}
