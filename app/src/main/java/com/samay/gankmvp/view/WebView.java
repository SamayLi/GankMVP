package com.samay.gankmvp.view;

import com.samay.gankmvp.presenter.WebPresenter;

/**
 * Created by baobao on 16/7/17.
 */

public interface WebView extends ISwipeRefreshView {
    void showLoadErrorMessage(String message);

}
