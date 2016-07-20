package com.samay.gankmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.mode.entity.Video;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by shaohua.li on 7/20/16.
 */
public class VideoAdapter  extends RecyclerView.Adapter<VideoAdapter.ViewHolder>  {
    public List<Video> videoList;
    public Context mContext;
    public LayoutInflater inflater;
    IItemClickListener listener;

    public void setListener(IItemClickListener listener) {
        this.listener = listener;
    }

    public VideoAdapter(Context mContext) {
        this.mContext = mContext;
        videoList=new ArrayList<>();
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_video,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Video video=videoList.get(position);
        holder.author.setText(video.getWho());
        holder.title.setText(video.getDesc());
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(video.getUrl(),video.getDesc());
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_video_title)
        TextView title;
        @BindView(R.id.tv_video_author)
        TextView author;
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



    public void setVideoList(List<Video> datas) {
        videoList.clear();
        videoList.addAll(datas);
        notifyDataSetChanged();
    }

    public void updateListWithoutClear(List<Video> datas){
        videoList.addAll(datas);
        notifyDataSetChanged();
    }
}
