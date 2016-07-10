package com.samay.gankmvp.view;

import com.samay.gankmvp.mode.entity.Android;

import java.util.List;

/**
 * Created by shaohua.li on 7/8/16.
 */
public interface AndroidView extends BaseView {

    void fillDatas(List<Android> androidList);
    void getDataFinished();
}
