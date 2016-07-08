package com.samay.gankmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samay.gankmvp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
{

    private List<String> mDatas;
    private Context mContext;

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
        mDatas=new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_fragment, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.id_num)
        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public void setmDatas(List<String> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
}