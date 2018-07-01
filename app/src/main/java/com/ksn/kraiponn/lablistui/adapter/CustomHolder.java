package com.ksn.kraiponn.lablistui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ksn.kraiponn.lablistui.R;

public class CustomHolder extends RecyclerView.ViewHolder {
    public ImageView imgIdRec;
    public TextView tvTopicRec;
    public TextView tvDescRec;


    public CustomHolder(View itemView) {
        super(itemView);
        imgIdRec = itemView.findViewById(R.id.image_recycler);
        tvTopicRec = itemView.findViewById(R.id.text_recycler_topic);
        tvDescRec = itemView.findViewById(R.id.text_recycler_desc);
    }

}
