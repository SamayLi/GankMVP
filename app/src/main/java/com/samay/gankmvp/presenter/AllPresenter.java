package com.samay.gankmvp.presenter;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.samay.gankmvp.mode.AllData;
import com.samay.gankmvp.mode.AndroidData;
import com.samay.gankmvp.mode.entity.All;
import com.samay.gankmvp.mode.entity.Android;
import com.samay.gankmvp.utils.InterntUtils;
import com.samay.gankmvp.view.AllView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AllPresenter implements BasePresenter<AllView> {
    private AllView mView;

    public AllPresenter(AllView mView) {
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
        InterntUtils interntUtils = new InterntUtils();
        interntUtils.getGankAPI().getALLs(10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<AllData, List<All>>() {
                    @Override
                    public List<All> call(AllData allData) {
                        return allData.results;
                    }
                }).subscribe(new Subscriber<List<All>>() {
            @Override
            public void onCompleted() {
                Logger.d("AllPresenter --> all  is completed");
                hasLoadMoreData = true;
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("AllPresenter --> error "+e.getMessage());
            }

            @Override
            public void onNext(List<All> alls) {
                if (alls == null) {
                    Logger.v("alls is null");
                } else {
                   Logger.v("alls size is "+alls.size());
                    mView.filldata(alls);
                }
            }
        });
    }


    boolean hasLoadMoreData = false;

    public boolean shouldRefillData() {
        return !hasLoadMoreData;
    }
}
