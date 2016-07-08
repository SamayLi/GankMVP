package com.samay.gankmvp.ui.activity;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.FragmentAdapter;
import com.samay.gankmvp.presenter.MainPresenter;
import com.samay.gankmvp.ui.fragment.AndroidFragment;
import com.samay.gankmvp.ui.fragment.BaseFragment;
import com.samay.gankmvp.ui.fragment.WelfareFragment;
import com.samay.gankmvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        final android.support.v7.app.ActionBar mActionBar=getSupportActionBar();
        mActionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        List<String> titles=new ArrayList<>();
        titles.add("福利");
        titles.add("Android");
        titles.add("IOS");
        titles.add("ALL");
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(3)));
        List<BaseFragment> fragmentList=new ArrayList<>();
        fragmentList.add(new WelfareFragment());
        fragmentList.add(new AndroidFragment());
        fragmentList.add(new WelfareFragment());
        fragmentList.add(new WelfareFragment());
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),fragmentList,titles);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void initPresenter() {
        mPresenter=new MainPresenter(this);
    }
}
