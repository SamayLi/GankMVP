package com.samay.gankmvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samay.gankmvp.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by shaohua.li on 7/7/16.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected  P mPresenter;

    public abstract int getLayoutId();

    public abstract void initPresenter();

    public abstract void initView();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

}
