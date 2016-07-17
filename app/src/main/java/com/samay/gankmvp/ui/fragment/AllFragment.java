package com.samay.gankmvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.AllAdapter;
import com.samay.gankmvp.adapter.IItemClickListener;
import com.samay.gankmvp.mode.entity.All;
import com.samay.gankmvp.presenter.AllPresenter;
import com.samay.gankmvp.ui.activity.WebActivity;
import com.samay.gankmvp.view.AllView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AllFragment extends BaseSwipeRefreshFragment<AllPresenter> implements AllView,IItemClickListener{

    @BindView(R.id.rv_all)
    RecyclerView recyclerView;

    AllAdapter allAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all;
    }

    @Override
    public void initPresenter() {
        mPresenter=new AllPresenter(this);
    }

    @Override
    public void initView() {
        initSwipeRefrashView();
        final LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        allAdapter=new AllAdapter(getContext());
        recyclerView.setAdapter(allAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isBottom =
                        layoutManager.findLastCompletelyVisibleItemPosition()
                                >= allAdapter.getItemCount() - 3;
                if(isBottom && !isRefreshing() && mPresenter.shouldRefillData()){
                    showRefresh();
                    mPresenter.loadMore();
                }

            }
        });
        allAdapter.setListener(this);
    }

    @Override
    protected void onRefreshStarted() {
        mPresenter.load();
    }

    @Override
    public void filldata(List<All> datas) {
        allAdapter.setAllList(datas);
    }

    @Override
    public void fillMoreData(List<All> datas) {
        allAdapter.updateAllListWithoutClear(datas);
    }

    @Override
    public void getDataFinished() {
        hideRefresh();
    }

    @Override
    public void showRefreshView() {
        showRefresh();
    }

    @Override
    protected boolean prepareRefresh() {
        return mPresenter.shouldRefillData();
    }

    @Override
    public void itemClick(String url, String title) {
        WebActivity.gotoWebActivity(getContext(),url,title);
    }
}
