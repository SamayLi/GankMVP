package com.samay.gankmvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.IItemClickListener;
import com.samay.gankmvp.adapter.IOSAdapter;
import com.samay.gankmvp.mode.entity.IOS;
import com.samay.gankmvp.presenter.IOSPresenter;
import com.samay.gankmvp.ui.activity.WebActivity;
import com.samay.gankmvp.view.IOSView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class IOSFragment extends BaseSwipeRefreshFragment<IOSPresenter> implements IOSView,IItemClickListener{
    @BindView(R.id.rv_ios)
    RecyclerView recyclerView;

    IOSAdapter iosAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ios;
    }

    @Override
    public void initPresenter() {
        mPresenter=new IOSPresenter(this);
    }

    @Override
    public void initView() {
        initSwipeRefrashView();
        final LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        iosAdapter=new IOSAdapter(getContext());
        recyclerView.setAdapter(iosAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isBottom =
                        layoutManager.findFirstCompletelyVisibleItemPosition()
                                >= iosAdapter.getItemCount() - 2;
                if(isBottom && !isRefreshing() && mPresenter.isHasLoadMoreData()){
                    showRefresh();
                    mPresenter.loadMore();
                }

            }
        });
        iosAdapter.setListener(this);
    }

    @Override
    public void fillDatas(List<IOS> datas) {
        iosAdapter.setIosList(datas);
    }

    @Override
    public void fillMoreDatas(List<IOS> datas) {
        iosAdapter.updateListWithoutClear(datas);
    }

    @Override
    public void getDataFinished() {
        hideRefresh();
    }

    @Override
    protected void onRefreshStarted() {
        mPresenter.load();
    }

    @Override
    protected boolean prepareRefresh() {
        return mPresenter.isHasLoadMoreData();
    }

    @Override
    public void showRefreshView() {
        showRefresh();
    }

    @Override
    public void itemClick(String url, String title) {
        WebActivity.gotoWebActivity(getContext(),url,title);
    }
}
