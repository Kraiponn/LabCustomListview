package com.ksn.kraiponn.lablistui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.manager.CustomGridViewItem;
import com.ksn.kraiponn.lablistui.manager.CustomItem;

import java.util.ArrayList;

public class CustomGridViewAdapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<CustomGridViewItem> mArrList;
    private ViewHolder mViewHolder;


    public CustomGridViewAdapter(@NonNull Context context,
                                 @NonNull ArrayList<CustomGridViewItem> arrayList)
    {
        super(context, 0, arrayList);
        mContext = context;
        mArrList = arrayList;
    }

    private class ViewHolder {

        public TextView tvTitle;
        public TextView tvContent;
        public ImageView imgContent;
        public CheckBox chkItemState;

        public ViewHolder(View cv) {
            tvTitle = cv.findViewById(R.id.textview_title);
            tvContent = cv.findViewById(R.id.textview_content);
            imgContent = cv.findViewById(R.id.imageview);
            chkItemState = cv.findViewById(R.id.check_box_grid);
        }

    }


    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(
                    R.layout.custom_grid_layout, parent, false
            );

            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        final CustomGridViewItem item = mArrList.get(position);
        mViewHolder.imgContent.setImageResource(item.imgId);
        mViewHolder.tvTitle.setText(item.textTitle);
        mViewHolder.tvContent.setText(item.textContent);
        mViewHolder.chkItemState.setChecked(item.isChecked);

        mViewHolder.chkItemState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chk = (CheckBox) v;
                item.isChecked = chk.isChecked();
            }
        });
        return convertView;
    }
}
