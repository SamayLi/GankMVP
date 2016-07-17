package com.samay.gankmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.mode.entity.Android;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder> {

    List<Android> androidDataList;
    Context mContext;
    LayoutInflater inflater;
    IItemClickListener listener;

    public void setListener(IItemClickListener listener) {
        this.listener = listener;
    }
    public AndroidAdapter(Context mContext) {
        this.mContext = mContext;
        androidDataList=new ArrayList<>();
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_android,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Android android=androidDataList.get(position);
        holder.mTitleView.setText(android.getDesc());
        holder.mAuthorView.setText("author:"+android.getWho());
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(android.getUrl(),android.getDesc());
            }
        });
    }


    @Override
    public int getItemCount() {
        return androidDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_android_item)
        TextView mTitleView;

        @BindView(R.id.iv_android_author)
        TextView mAuthorView;
        View view;

        public View getView() {
            return view;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            ButterKnife.bind(this,itemView);
        }
    }

    public void setAndroidDataList(List<Android> dataList) {
        androidDataList.clear();
        androidDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void updateAllWithoutClear(List<Android> datalist){
        androidDataList.addAll(datalist);
        notifyDataSetChanged();
    }
}
