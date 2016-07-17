package com.samay.gankmvp.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.samay.gankmvp.R;
import com.samay.gankmvp.presenter.BasePresenter;
import com.samay.gankmvp.view.ISwipeRefreshView;

import butterknife.BindView;

/**
 * Created by baobao on 16/7/17.
 */

public abstract class BaseSwipeRefreshActivity<P extends BasePresenter> extends BaseActivity<P> implements ISwipeRefreshView {

    @BindView(R.id.swipe_refresh_layout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSwipeLayout();
    }

    private void initSwipeLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (prepareRefresh()) {
                    onRefreshStarted();
                } else {
                    //产生一个加载数据的假象
                    hideRefresh();
                }
            }
        });
    }

    /**
     * check data status
     * @return return true indicate it should load data really else indicate don't refresh
     */
    protected boolean prepareRefresh(){
        return true;
    }

    /**
     * the method of get data
     */
    protected abstract void onRefreshStarted();

    @Override
    public void hideRefresh() {
        // 防止刷新消失太快，让子弹飞一会儿. do not use lambda!!
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mSwipeRefreshLayout != null){
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        },1000);
    }

    @Override
    public void showRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
    }


    public boolean isRefreshing(){
        return mSwipeRefreshLayout.isRefreshing();
    }

    public void getDataFinish() {
        hideRefresh();
    }
}
