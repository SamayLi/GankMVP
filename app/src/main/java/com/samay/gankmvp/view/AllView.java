package com.samay.gankmvp.view;

import com.samay.gankmvp.mode.entity.All;

import java.util.List;

/**
 * Created by shaohua.li on 7/8/16.
 */
public interface AllView extends BaseView{
    void filldata(List<All> datas);
    void fillMoreData(List<All> datas);
    void getDataFinished();
    void showRefreshView();
}
