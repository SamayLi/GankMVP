package com.samay.gankmvp.view;

import com.samay.gankmvp.mode.entity.Welfare;

import java.util.List;

/**
 * Created by shaohua.li on 7/7/16.
 */
public interface WelfareView extends BaseView {
    void load(String content);
    void fillDatas(List<Welfare> datas);
    void fillDatasMore(List<Welfare> moreDatas);
}
