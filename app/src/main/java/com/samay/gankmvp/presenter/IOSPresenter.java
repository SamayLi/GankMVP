package com.samay.gankmvp.presenter;

import com.samay.gankmvp.view.IOSView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class IOSPresenter implements BasePresenter<IOSView> {

    private IOSView mView;

    public IOSPresenter(IOSView mView) {
        this.mView = mView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
