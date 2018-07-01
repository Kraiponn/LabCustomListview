package com.ksn.kraiponn.lablistui.dao;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.manager.CustomItem;

import java.util.ArrayList;
import java.util.Arrays;

public class DataPacketTemplate {

    public ArrayList<CustomItem> mArrList;

    public DataPacketTemplate() {
        //
    }

    public ArrayList<CustomItem> getArrCustomData() {
        mArrList = new ArrayList<>();
        mArrList.addAll(Arrays.asList(
                new CustomItem(R.drawable.ic_android,
                        "Android",
                        "Android developer",
                        false),
                new CustomItem(R.drawable.ic_bluetooth,
                        "BlueTooth",
                        "Interface data with bluetooth",
                        false),
                new CustomItem(R.drawable.ic_account,
                        "Account",
                        "Customer of our products",
                        false),
                new CustomItem(R.drawable.ic_computer,
                        "Computer",
                        "It system for analysis",
                        false),
                new CustomItem(R.drawable.ic_fingerprint,
                        "Finger Scanner",
                        "The finger scanner for access the system",
                        false)
        ));

        return mArrList;
    }

}
