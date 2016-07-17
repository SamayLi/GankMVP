package com.samay.gankmvp.utils;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by baobao on 16/7/10.
 */

public class CommonUtils {

    public static final String TAG="Gank@@@@";

    public static TextView getTitleViewInToolbar(Toolbar obj){
        TextView textView = null;
        try {
            Field title = obj.getClass().getDeclaredField("mTitleTextView");
            title.setAccessible(true);
            textView = (TextView) title.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return textView;
    }
}
