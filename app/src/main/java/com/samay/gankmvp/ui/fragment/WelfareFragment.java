package com.samay.gankmvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.HomeAdapter;
import com.samay.gankmvp.adapter.WelfareAdapter;
import com.samay.gankmvp.mode.entity.Welfare;
import com.samay.gankmvp.presenter.WelfarePresenter;
import com.samay.gankmvp.view.WelfareView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class WelfareFragment extends BaseFragment<WelfarePresenter> implements WelfareView {

    @BindView(R.id.rv_welfare)
    RecyclerView recyclerView;

    private WelfareAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_welfare;
    }

    @Override
    public void initPresenter() {
        mPresenter = new WelfarePresenter(this);
    }



    @Override
    public void initView() {
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new WelfareAdapter(getActivity().getBaseContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void load(String content) {
        Log.d("samay@@@","content is "+content);
    }

    @Override
    public void fillDatas(List<Welfare> datas) {
        Log.d("samay@@@","datas size is "+datas.size());
        adapter.setWelfareList(datas);
    }
}
