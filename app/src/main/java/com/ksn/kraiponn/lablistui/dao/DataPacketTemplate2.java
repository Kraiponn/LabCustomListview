package com.ksn.kraiponn.lablistui.dao;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.manager.CustomGridViewItem;
import com.ksn.kraiponn.lablistui.manager.CustomItem;

import java.util.ArrayList;
import java.util.Arrays;

public class DataPacketTemplate2 {

    public ArrayList<CustomGridViewItem> mArrList;

    public DataPacketTemplate2() {
        //
    }

    public ArrayList<CustomGridViewItem> getArrCustomData() {
        mArrList = new ArrayList<>();
        mArrList.addAll(Arrays.asList(
                new CustomGridViewItem(R.drawable.bg,
                        "Android",
                        "Android developer",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "BlueTooth",
                        "Interface data with bluetooth",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Account",
                        "Customer of our products",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Computer",
                        "It system for analysis",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),
                new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false),new CustomGridViewItem(R.drawable.bg,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false)
        ));

        return mArrList;
    }

}
