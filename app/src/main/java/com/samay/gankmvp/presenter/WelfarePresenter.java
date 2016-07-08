package com.samay.gankmvp.presenter;

import android.util.Log;

import com.samay.gankmvp.mode.WelfareData;
import com.samay.gankmvp.mode.entity.Welfare;
import com.samay.gankmvp.utils.InterntUtils;
import com.samay.gankmvp.view.WelfareView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class WelfarePresenter implements BasePresenter<WelfareView> {
    private WelfareView mView;

    public WelfarePresenter(WelfareView mView) {
        this.mView = mView;
    }

    @Override
    public void subscribe() {
        load();
    }

    @Override
    public void unsubscribe() {

    }


    public void load() {
        mView.load("This is test");
        InterntUtils interntUtils = new InterntUtils();
        interntUtils.getGankAPI().getWelfare(10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<WelfareData, List<Welfare>>() {
                    @Override
                    public List<Welfare> call(WelfareData welfareData) {
                        return welfareData.results;
                    }
                }).subscribe(new Subscriber<List<Welfare>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("samay@@@", "e is " + e.toString());
                Log.d("samay@@@", "loadData error");
            }

            @Override
            public void onNext(List<Welfare> welfares) {
                if (welfares == null) {
                    Log.d("samay@@@@", "welfares is null");
                } else {
                    Log.d("samay@@@@", "welfares is not null");
                    Log.d("samay@@@@","welfares size is "+welfares.size());
                    mView.fillDatas(welfares);
                }
            }
        });

    }

}
