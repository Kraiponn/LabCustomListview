package com.ksn.kraiponn.lablistui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.manager.RecyclerItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<RecyclerItem> mArr;
    private Context mContext;
    private MyViewHolder vHolder;

    public interface onItemClickListener{
        void onItemClick(View v, int position);
    }

    private onItemClickListener mListener;

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    public RecyclerAdapter(ArrayList<RecyclerItem> mItem, Context mContext) {
        this.mArr = mItem;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                           int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(
                R.layout.item_recycler_layout,
                parent, false
        );

        vHolder = new MyViewHolder(view);
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int pos = vHolder.getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(v, pos);
                    }
                }
            }
        });*/

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecyclerItem item = mArr.get(position);
        holder.imgIdRec.setImageResource(item.imageId);
        holder.tvTopicRec.setText(item.textTopic);
        holder.tvDescRec.setText(item.textDesc);
    }


    @Override
    public int getItemCount() {
        return mArr.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public ImageView imgIdRec;
        public TextView tvTopicRec;
        public TextView tvDescRec;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgIdRec = itemView.findViewById(R.id.image_recycler);
            tvTopicRec = itemView.findViewById(R.id.text_recycler_topic);
            tvDescRec = itemView.findViewById(R.id.text_recycler_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }
    }

}
