package com.ksn.kraiponn.lablistui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.manager.ChildItem;
import com.ksn.kraiponn.lablistui.manager.SectionItem;

import java.util.ArrayList;

public class RecyclerMultiLayoutAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList mDataSet;
    private final int SECTION_ITEM = 0;
    private final int CHILD_ITEM = 1;
    private onItemClickListener mCallBack;

    public interface onItemClickListener{
        void onItemClick(View v, int position);
    }

    public RecyclerMultiLayoutAdapter(Context mContext, ArrayList mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        //RecyclerView.ViewHolder vHolder;

        if (viewType == SECTION_ITEM) {
            View view = inflater.inflate(
                    R.layout.section_layout, parent, false
            );

            SectionHolder vHolder = new SectionHolder(view);
            return vHolder;
        } else if (viewType == CHILD_ITEM) {
            View view = inflater.inflate(
                    R.layout.child_layout, parent, false
            );

            ChildHolder vHolder = new ChildHolder(view);
            return vHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,
                                 int position) {
        int viewType = getItemViewType(position);
        if (viewType == SECTION_ITEM) {
            SectionItem item = (SectionItem) mDataSet.get(position);
            SectionHolder vHoler = (SectionHolder) holder;

            vHoler.tvSection.setText(item.getmSectionText());
        } else if (viewType == CHILD_ITEM) {
            ChildItem item = (ChildItem) mDataSet.get(position);
            ChildHolder vHolder = (ChildHolder) holder;

            vHolder.tvChild.setText(item.getmChildText());
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSet.get(position) instanceof SectionItem) {
            return SECTION_ITEM;
        } else if (mDataSet.get(position) instanceof ChildItem) {
            return CHILD_ITEM;
        }

        return -1;
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mCallBack = listener;
    }


    /****************************
     *      Sub Class
     ***************************/
    public class SectionHolder extends RecyclerView.ViewHolder {
        public TextView tvSection;

        public SectionHolder(View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.textView_section);
        }

    }

    public class ChildHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public TextView tvChild;

        public ChildHolder(View itemView) {
            super(itemView);
            tvChild = itemView.findViewById(R.id.textView_child);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallBack.onItemClick(v, getAdapterPosition());
        }

    }

}
