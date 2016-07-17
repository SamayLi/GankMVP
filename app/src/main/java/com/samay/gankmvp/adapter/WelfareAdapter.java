package com.samay.gankmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samay.gankmvp.R;
import com.samay.gankmvp.mode.entity.Welfare;
import com.samay.gankmvp.utils.DateUtils;
import com.samay.gankmvp.widget.RatioImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.BindView;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.ViewHolder> {

    private Context mContext;
    private List<Welfare> welfareList;
    private LayoutInflater inflater;


    public interface IItemClickLister{
        void itemClick(String url, String s, RatioImageView ratioImageView, TextView welfareText);
    }

    private IItemClickLister lister;

    public void setLister(IItemClickLister lister) {
        this.lister = lister;
    }

    public WelfareAdapter(Context context) {
        mContext = context;
        welfareList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_welfare, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final Welfare welfare = welfareList.get(position);
        viewHolder.welfareText.setText(DateUtils.toDate(welfare.getPublishedAt()));
        Glide.with(mContext).load(welfare.getUrl()).centerCrop().into(viewHolder.ratioImageView);
        viewHolder.ratioImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lister.itemClick(welfare.getUrl(),DateUtils.toDate(welfare.getPublishedAt()),viewHolder.ratioImageView,viewHolder.welfareText);
            }
        });
    }

    @Override
    public int getItemCount() {
        return welfareList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_welfare_pic)
        RatioImageView ratioImageView;
        @BindView(R.id.tv_welfare_time)
        TextView welfareText;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ratioImageView.setOriginalSize(50,50);
        }

    }

    public void setWelfareList(List<Welfare> datas) {
        welfareList.clear();
        welfareList.addAll(datas);
        notifyDataSetChanged();
    }

    public void updateWelfareWithoutClear(List<Welfare> datas){
        welfareList.addAll(datas);
        notifyDataSetChanged();
    }
}
