package com.samay.gankmvp.presenter;

import android.util.Log;

import com.samay.gankmvp.mode.VideoData;
import com.samay.gankmvp.mode.entity.Video;
import com.samay.gankmvp.utils.InterntUtils;
import com.samay.gankmvp.view.VideoView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shaohua.li on 7/20/16.
 */
public class VideoPresenter implements BasePresenter<VideoView> {

    private VideoView mView;
    int current_page=1;
    final int page_size=10;

    public VideoPresenter(VideoView mView) {
        this.mView = mView;
    }

    @Override
    public void subscribe() {
        mView.showRefreshView();
        load();
    }

    @Override
    public void unsubscribe() {

    }
    public void load() {
        current_page=1;
        InterntUtils interntUtils = new InterntUtils();
        interntUtils.getGankAPI().getVideo(10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<VideoData, List<Video>>() {
                    @Override
                    public List<Video> call(VideoData videoData) {
                        return videoData.results;
                    }
                }).subscribe(new Subscriber<List<Video>>() {
            @Override
            public void onCompleted() {
                Log.d("samay@@@", "video is completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("samay@@@", "e is " + e.toString());
                Log.d("samay@@@", "loadData error");
                mView.getDataFinished();
            }

            @Override
            public void onNext(List<Video> videos) {
                if (videos == null) {
                    Log.d("samay@@@@", "video is null");
                } else {
                    Log.d("samay@@@@", "video is not null");
                    Log.d("samay@@@@", "video size is " + videos.size());
                    if(videos.size()==10){
                        current_page++;
                    }
                    mView.fillDatas(videos);
                }
                mView.getDataFinished();
            }
        });
    }


    public void loadMore() {
        InterntUtils interntUtils = new InterntUtils();
        interntUtils.getGankAPI().getVideo(page_size, current_page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<VideoData, List<Video>>() {
                    @Override
                    public List<Video> call(VideoData videoData) {
                        return videoData.results;
                    }
                }).subscribe(new Subscriber<List<Video>>() {
            @Override
            public void onCompleted() {
                Log.d("samay@@@", "video is completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("samay@@@", "e is " + e.toString());
                Log.d("samay@@@", "loadData error");
                mView.getDataFinished();
            }

            @Override
            public void onNext(List<Video> videos) {
                if (videos == null) {
                    Log.d("samay@@@@", "video is null");
                } else {
                    Log.d("samay@@@@", "video is not null");
                    Log.d("samay@@@@", "video size is " + videos.size());
                    if(videos.size()==10){
                        current_page++;
                    }else {
                        hasLoadMoreData=false;
                    }
                    mView.fillMoreDatas(videos);
                    mView.getDataFinished();
                }
            }
        });
    }


    boolean hasLoadMoreData = true;


    public boolean isHasLoadMoreData() {
        return hasLoadMoreData;
    }
}
