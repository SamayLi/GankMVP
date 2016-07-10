package com.samay.gankmvp;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.samay.gankmvp.utils.CommonUtils;

/**
 * Created by baobao on 16/7/10.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(CommonUtils.TAG);
    }
}
