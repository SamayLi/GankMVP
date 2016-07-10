package com.samay.gankmvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;

import com.samay.gankmvp.R;
import com.samay.gankmvp.presenter.BasePresenter;
import com.samay.gankmvp.view.ISwipeRefreshView;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public abstract class BaseSwipeRefreshFragment<P extends BasePresenter> extends BaseFragment<P> implements ISwipeRefreshView {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;


    protected void initSwipeRefrashView(){
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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

    @Override
    public void getDataFinish() {
        hideRefresh();
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView(Throwable throwable) {

    }


    /**
     * check data status
     * @return return true indicate it should load data really else indicate don't refresh
     */
    protected boolean prepareRefresh(){
        return false;
    }

    /**
     * the method of get data
     */
    protected abstract void onRefreshStarted();

    @Override
    public void hideRefresh() {
        // 防止刷新消失太快，让子弹飞一会儿. do not use lambda!!
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(swipeRefreshLayout != null){
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        },1000);
    }
}
