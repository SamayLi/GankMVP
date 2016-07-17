package com.samay.gankmvp.presenter;

import com.samay.gankmvp.view.WelfareDetailView;

/**
 * Created by baobao on 16/7/16.
 */

public class WelfareDetailPresenter implements BasePresenter<WelfareDetailView> {

    private WelfareDetailView mView;

    public WelfareDetailPresenter(WelfareDetailView mView) {
        this.mView = mView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
