package com.samay.gankmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samay.gankmvp.R;
import com.samay.gankmvp.mode.entity.IOS;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaohua.li on 7/8/16.
 */
public class IOSAdapter extends RecyclerView.Adapter<IOSAdapter.ViewHolder> {

    public List<IOS> iosList;
    public Context mContext;
    public LayoutInflater inflater;
    IItemClickListener listener;

    public void setListener(IItemClickListener listener) {
        this.listener = listener;
    }

    public IOSAdapter(Context mContext) {
        this.mContext = mContext;
        iosList=new ArrayList<>();
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_ios,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final IOS ios=iosList.get(position);
        holder.author.setText(ios.getWho());
        holder.title.setText(ios.getDesc());
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(ios.getUrl(),ios.getDesc());
            }
        });
    }

    @Override
    public int getItemCount() {
        return iosList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_ios_title)
        TextView title;
        @BindView(R.id.tv_ios_author)
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

    public void setIosList(List<IOS> datas) {
        iosList.clear();
        iosList.addAll(datas);
        notifyDataSetChanged();
    }

    public void updateListWithoutClear(List<IOS> datas){
        iosList.addAll(datas);
        notifyDataSetChanged();
    }


}
