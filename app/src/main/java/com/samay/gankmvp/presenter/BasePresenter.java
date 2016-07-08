package com.samay.gankmvp.presenter;

import com.samay.gankmvp.view.BaseView;

/**
 * Created by shaohua.li on 7/7/16.
 */
public interface BasePresenter<T extends BaseView> {
    void subscribe();
    void unsubscribe();
}
