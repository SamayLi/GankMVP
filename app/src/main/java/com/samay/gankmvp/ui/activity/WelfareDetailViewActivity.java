package com.samay.gankmvp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samay.gankmvp.R;
import com.samay.gankmvp.adapter.WelfareAdapter;
import com.samay.gankmvp.presenter.WelfareDetailPresenter;
import com.samay.gankmvp.utils.CommonUtils;
import com.samay.gankmvp.view.WelfareDetailView;
import com.samay.gankmvp.widget.RatioImageView;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by baobao on 16/7/16.
 */

public class WelfareDetailViewActivity extends BaseActivity<WelfareDetailPresenter> implements WelfareDetailView{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.iv_girl_detail)
    ImageView girlDetailView;

    private String mUrl;
    PhotoViewAttacher mAttacher;


    private static final String EXTRA_BUNDLE_URL = "BUNDLE_URL";
    private static final String EXTRA_BUNDLE_TITLE = "BUNDLE_TITLE";

    private static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";
    private static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    @Override
    public int getLayoutId() {
        return R.layout.activity_welfare_detail;
    }

    @Override
    public void initView() {
        initToolBar();
        setTitle(getIntent().getStringExtra(EXTRA_BUNDLE_TITLE), true);
        mAttacher=new PhotoViewAttacher(girlDetailView);
        mUrl=getIntent().getStringExtra(EXTRA_BUNDLE_URL);
        ViewCompat.setTransitionName(girlDetailView, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(CommonUtils.getTitleViewInToolbar(mToolbar), VIEW_NAME_HEADER_TITLE);

        loadFullSizeImage();
    }

    @Override
    public void initPresenter() {
        mPresenter=new WelfareDetailPresenter(this);
    }

    private void initToolBar() {
        if(mToolbar == null){
            throw new NullPointerException("please add a Toolbar in your layout.");
        }
        setSupportActionBar(mToolbar);
    }

    public void setTitle(String strTitle,boolean showHome){
        setTitle(strTitle);
        getSupportActionBar().setDisplayShowHomeEnabled(showHome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHome);
    }

    public static void gotoWatchGirlDetail(Activity context, String url, String title, final View viewImage, final View viewText){
        Intent intent = new Intent(context,WelfareDetailViewActivity.class);
        intent.putExtra(EXTRA_BUNDLE_URL,url);
        intent.putExtra(EXTRA_BUNDLE_TITLE,title);

        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context,new Pair<View, String>(viewImage,
                        VIEW_NAME_HEADER_IMAGE),
                new Pair<View, String>(viewText,
                        VIEW_NAME_HEADER_TITLE));

        ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
    }


    private void loadFullSizeImage() {
        Glide.with(this)
                .load(mUrl)
                .crossFade()
                .centerCrop()
                .into(girlDetailView);
    }


}
