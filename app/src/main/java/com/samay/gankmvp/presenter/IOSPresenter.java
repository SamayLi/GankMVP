package com.samay.gankmvp.presenter;

import android.util.Log;

import com.samay.gankmvp.mode.AndroidData;
import com.samay.gankmvp.mode.IOSData;
import com.samay.gankmvp.mode.entity.Android;
import com.samay.gankmvp.mode.entity.IOS;
import com.samay.gankmvp.utils.InterntUtils;
import com.samay.gankmvp.view.IOSView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class IOSPresenter implements BasePresenter<IOSView> {

    private IOSView mView;

    public IOSPresenter(IOSView mView) {
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
        interntUtils.getGankAPI().getIOSs(10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<IOSData, List<IOS>>() {
                    @Override
                    public List<IOS> call(IOSData iosData) {
                        return iosData.results;
                    }
                }).subscribe(new Subscriber<List<IOS>>() {
            @Override
            public void onCompleted() {
                Log.d("samay@@@", "ios is completed");
                hasLoadMoreData = true;
            }

            @Override
            public void onError(Throwable e) {
                Log.d("samay@@@", "e is " + e.toString());
                Log.d("samay@@@", "loadData error");
            }

            @Override
            public void onNext(List<IOS> ioses) {
                if (ioses == null) {
                    Log.d("samay@@@@", "ios is null");
                } else {
                    Log.d("samay@@@@", "ios is not null");
                    Log.d("samay@@@@", "ios size is " + ioses.size());
                    mView.fillDatas(ioses);
                }
            }
        });
    }


    boolean hasLoadMoreData = false;

    public boolean shouldRefillData() {
        return !hasLoadMoreData;
    }
}
