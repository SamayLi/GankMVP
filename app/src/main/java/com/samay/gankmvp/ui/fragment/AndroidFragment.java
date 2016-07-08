package com.samay.gankmvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.AndroidAdapter;
import com.samay.gankmvp.mode.entity.Android;
import com.samay.gankmvp.presenter.AndroidPresenter;
import com.samay.gankmvp.view.AndroidView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AndroidFragment extends BaseSwipeRefreshFragment<AndroidPresenter> implements AndroidView {

    @BindView(R.id.rv_android)
    RecyclerView recyclerView;

    private AndroidAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_android;
    }

    @Override
    public void initPresenter() {
        mPresenter=new AndroidPresenter(this);
    }

    @Override
    public void initView() {
        initSwipeRefrashView();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AndroidAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fillDatas(List<Android> androidList) {
        Log.d("samay@@@Android","android List size is "+androidList.size());
        adapter.setAndroidDataList(androidList);
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
