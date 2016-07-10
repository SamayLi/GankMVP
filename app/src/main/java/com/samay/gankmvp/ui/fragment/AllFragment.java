package com.samay.gankmvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.AllAdapter;
import com.samay.gankmvp.mode.entity.All;
import com.samay.gankmvp.presenter.AllPresenter;
import com.samay.gankmvp.view.AllView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AllFragment extends BaseSwipeRefreshFragment<AllPresenter> implements AllView{

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
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        allAdapter=new AllAdapter(getContext());
        recyclerView.setAdapter(allAdapter);
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
    protected boolean prepareRefresh() {
        return mPresenter.shouldRefillData();
    }
}
