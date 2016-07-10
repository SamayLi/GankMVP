package com.samay.gankmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.samay.gankmvp.R;
import com.samay.gankmvp.mode.entity.All;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baobao on 16/7/10.
 */

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.ViewHolder> {

    List<All> allList;

    Context mContext;

    LayoutInflater inflater;

    public AllAdapter(Context mContext) {
        this.mContext = mContext;
        allList=new ArrayList<>();
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_all,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        All all=allList.get(position);
        holder.author.setText(all.getWho());
        holder.title.setText(all.getDesc());
    }

    @Override
    public int getItemCount() {
        return allList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_all_item)
        TextView title;
        @BindView(R.id.tv_all_author)
        TextView author;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void setAllList(List<All> datas) {
        allList.clear();
        allList.addAll(datas);
        notifyDataSetChanged();
    }

    public void updateAllListWithoutClear(List<All> datas){
        allList.addAll(datas);
        notifyDataSetChanged();
    }
}
