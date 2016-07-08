package com.samay.gankmvp.presenter;

import com.samay.gankmvp.view.MainView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class MainPresenter implements BasePresenter<MainView> {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
