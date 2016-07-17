package com.samay.gankmvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.samay.gankmvp.R;
import com.samay.gankmvp.presenter.WebPresenter;
import com.samay.gankmvp.view.WebView;

import butterknife.BindView;

/**
 * Created by baobao on 16/7/17.
 */

public class WebActivity extends BaseSwipeRefreshActivity<WebPresenter> implements WebView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @Override
    protected void onRefreshStarted() {
        refresh();
    }

    private void refresh() {
        mWbContent.reload();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void initView() {
        initToolBar();
        String url = getIntent().getStringExtra(EXTRA_URL);
        String title = getIntent().getStringExtra(EXTRA_TITLE);

        if(!TextUtils.isEmpty(title)){
            setTitle(title,true);
        }
        mPresenter.setUpWebView(mWbContent);
        mPresenter.loadUrl(mWbContent,url);
    }

    @Override
    public void initPresenter() {
        mPresenter=new WebPresenter(this);
    }

    @Override
    public void showLoadErrorMessage(String message) {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView(Throwable throwable) {

    }

    private static final String EXTRA_URL = "URL";
    private static final String EXTRA_TITLE = "TITLE";

    @BindView(R.id.wb_content)
    android.webkit.WebView mWbContent;

    public static void gotoWebActivity(Context context, String url, String title){
        Intent intent = new Intent(context,WebActivity.class);
        intent.putExtra(EXTRA_URL,url);
        intent.putExtra(EXTRA_TITLE, title);
        context.startActivity(intent);
    }


    public void setTitle(String strTitle,boolean showHome){
        setTitle(strTitle);
        getSupportActionBar().setDisplayShowHomeEnabled(showHome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHome);
    }

    private void initToolBar() {
        if(mToolbar == null){
            throw new NullPointerException("please add a Toolbar in your layout.");
        }
        setSupportActionBar(mToolbar);
    }
}
