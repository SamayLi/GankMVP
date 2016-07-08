package com.samay.gankmvp.presenter;

import com.samay.gankmvp.view.AllView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AllPresenter implements BasePresenter<AllView> {
    private AllView mView;

    public AllPresenter(AllView mView) {
        this.mView = mView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
