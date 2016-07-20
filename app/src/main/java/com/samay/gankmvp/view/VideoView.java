package com.samay.gankmvp.view;

import com.samay.gankmvp.mode.entity.IOS;
import com.samay.gankmvp.mode.entity.Video;

import java.util.List;

/**
 * Created by shaohua.li on 7/20/16.
 */
public interface VideoView extends BaseView {
    void fillDatas(List<Video> datas);
    void fillMoreDatas(List<Video> datas);
    void getDataFinished();
    void showRefreshView();
}
