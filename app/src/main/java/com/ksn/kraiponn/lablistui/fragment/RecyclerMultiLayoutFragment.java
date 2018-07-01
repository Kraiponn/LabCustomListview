package com.ksn.kraiponn.lablistui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.adapter.RecyclerMultiLayoutAdapter;
import com.ksn.kraiponn.lablistui.manager.ChildItem;
import com.ksn.kraiponn.lablistui.manager.SectionItem;

import java.util.ArrayList;

public class RecyclerMultiLayoutFragment extends Fragment {

    private RecyclerView rcv;
    private ArrayList arrDataSet;

    public RecyclerMultiLayoutFragment() {
        super();
    }

    public static RecyclerMultiLayoutFragment newInstance() {
        RecyclerMultiLayoutFragment fragment =
                new RecyclerMultiLayoutFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
        View v = inflater.inflate(
                R.layout.fragment_recc_multi_layout,
                container, false
        );

        initInstacne(v);
        return v;
    }

    private void initInstacne(View v) {
        rcv = v.findViewById(R.id.recyclerView);
        arrDataSet = new ArrayList();

        arrDataSet.add(new SectionItem("Mobile"));
        arrDataSet.add(new ChildItem("Android OS"));
        arrDataSet.add(new ChildItem("IOS (Apple)"));
        arrDataSet.add(new ChildItem("Windows OS"));
        arrDataSet.add(new ChildItem("Symbian OS"));

        arrDataSet.add(new SectionItem("Web Application"));
        arrDataSet.add(new ChildItem("PHP Laravel"));
        arrDataSet.add(new ChildItem("PHP Yii"));
        arrDataSet.add(new ChildItem("PHO Code-Igneter"));
        arrDataSet.add(new ChildItem("Node JS"));
        arrDataSet.add(new ChildItem("ASP.Net MVC"));
        arrDataSet.add(new ChildItem("Java Spring"));

        RecyclerMultiLayoutAdapter adapter =
                new RecyclerMultiLayoutAdapter(getActivity(), arrDataSet);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //rcv.setHasFixedSize(true);

        adapter.setOnItemClickListener(new RecyclerMultiLayoutAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ChildItem item = (ChildItem) arrDataSet.get(position);
                Toast.makeText(getContext(),
                        "" + item.getmChildText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
