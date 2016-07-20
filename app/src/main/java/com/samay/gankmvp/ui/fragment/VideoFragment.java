package com.samay.gankmvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.IItemClickListener;
import com.samay.gankmvp.adapter.IOSAdapter;
import com.samay.gankmvp.adapter.VideoAdapter;
import com.samay.gankmvp.mode.entity.Video;
import com.samay.gankmvp.presenter.VideoPresenter;
import com.samay.gankmvp.ui.activity.WebActivity;
import com.samay.gankmvp.view.VideoView;

import java.util.List;
import butterknife.BindView;

/**
 * Created by shaohua.li on 7/20/16.
 */
public class VideoFragment extends BaseSwipeRefreshFragment<VideoPresenter> implements VideoView,IItemClickListener {
    @BindView(R.id.rv_video)
    RecyclerView recyclerView;

    VideoAdapter videoAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initPresenter() {
        mPresenter=new VideoPresenter(this);
    }

    @Override
    public void initView() {
        initSwipeRefrashView();
        final LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        videoAdapter=new VideoAdapter(getContext());
        recyclerView.setAdapter(videoAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isBottom =
                        layoutManager.findLastCompletelyVisibleItemPosition()
                                >= videoAdapter.getItemCount() - 3;
                Log.d("samay@@@", "isBottom is " + isBottom);
                if (isBottom && !isRefreshing() && mPresenter.isHasLoadMoreData()) {
                    Log.d("samay@@@", "recycler View is refresh");
                    showRefresh();
                    mPresenter.loadMore();
                }

            }
        });
        videoAdapter.setListener(this);
    }

    @Override
    public void itemClick(String url, String title) {
        WebActivity.gotoWebActivity(getContext(), url, title);
    }

    @Override
    public void fillDatas(List<Video> datas) {
        videoAdapter.setVideoList(datas);
    }

    @Override
    public void fillMoreDatas(List<Video> datas) {
        videoAdapter.updateListWithoutClear(datas);
    }

    @Override
    public void getDataFinished() {
        hideRefresh();
    }

    @Override
    public void showRefreshView() {
        mPresenter.load();
    }

    @Override
    protected boolean prepareRefresh() {
        return mPresenter.isHasLoadMoreData();
    }

    @Override
    protected void onRefreshStarted() {
        mPresenter.load();
    }
}
