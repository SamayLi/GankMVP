package com.samay.gankmvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.samay.gankmvp.presenter.BasePresenter;
import com.samay.gankmvp.view.BaseView;

import butterknife.ButterKnife;

/**
 * Created by shaohua.li on 7/8/16.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    public abstract int getLayoutId();

    public abstract void initView();
    public abstract void initPresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initPresenter();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unsubscribe();
    }
}
