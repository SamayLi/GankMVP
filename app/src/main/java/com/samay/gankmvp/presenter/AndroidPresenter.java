package com.samay.gankmvp.presenter;

import android.util.Log;

import com.samay.gankmvp.mode.AndroidData;
import com.samay.gankmvp.mode.WelfareData;
import com.samay.gankmvp.mode.entity.Android;
import com.samay.gankmvp.mode.entity.Welfare;
import com.samay.gankmvp.utils.InterntUtils;
import com.samay.gankmvp.view.AndroidView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AndroidPresenter implements BasePresenter<AndroidView> {

    int current_page=1;
    final int page_size=10;

    private AndroidView mView;


    public AndroidPresenter(AndroidView view) {
        mView = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    public void load() {
        InterntUtils interntUtils = new InterntUtils();
        interntUtils.getGankAPI().getAndroids(page_size, current_page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<AndroidData, List<Android>>() {
                    @Override
                    public List<Android> call(AndroidData androidData) {
                        return androidData.results;
                    }
                }).subscribe(new Subscriber<List<Android>>() {
            @Override
            public void onCompleted() {
                Log.d("samay@@@", "android is completed");
                hasLoadMoreData = true;
            }

            @Override
            public void onError(Throwable e) {
                Log.d("samay@@@", "e is " + e.toString());
                Log.d("samay@@@", "loadData error");
                mView.getDataFinished();
            }

            @Override
            public void onNext(List<Android> androids) {
                if (androids == null) {
                    Log.d("samay@@@@", "androids is null");
                } else {
                    Log.d("samay@@@@", "androids is not null");
                    Log.d("samay@@@@", "androids size is " + androids.size());
                    mView.fillDatas(androids);
                }
                mView.getDataFinished();
            }
        });
    }


    boolean hasLoadMoreData = false;

    public boolean shouldRefillData() {
        return !hasLoadMoreData;
    }
}
