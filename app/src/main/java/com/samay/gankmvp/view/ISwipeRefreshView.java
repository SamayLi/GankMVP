package com.samay.gankmvp.view;

/**
 * Created by shaohua.li on 7/8/16.
 */
public interface ISwipeRefreshView extends BaseView {

    void showEmptyView();

    void showErrorView(Throwable throwable);

    void hideRefresh();

    boolean isRefreshing();

    void showRefresh();
}
