package com.samay.gankmvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.IOSAdapter;
import com.samay.gankmvp.mode.entity.IOS;
import com.samay.gankmvp.presenter.IOSPresenter;
import com.samay.gankmvp.view.IOSView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class IOSFragment extends BaseSwipeRefreshFragment<IOSPresenter> implements IOSView{
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
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        iosAdapter=new IOSAdapter(getContext());
        recyclerView.setAdapter(iosAdapter);
    }

    @Override
    public void fillDatas(List<IOS> datas) {
        iosAdapter.setIosList(datas);
    }

    @Override
    protected void onRefreshStarted() {
        mPresenter.load();
    }

    @Override
    protected boolean prepareRefresh() {
        return mPresenter.shouldRefillData();
    }
}
