package com.ksn.kraiponn.lablistui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ksn.kraiponn.lablistui.R;

public class FullCrudListViewFragment extends Fragment {
    /********************
     *  Variable
     ******************/
    private Toolbar toolbar;

    public FullCrudListViewFragment() {
        super();
    }

    public static FullCrudListViewFragment newInstance() {
        FullCrudListViewFragment fm = new FullCrudListViewFragment();
        Bundle args = new Bundle();
        fm.setArguments(args);
        return fm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_full_crud, container, false
        );

        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {
    }
}
