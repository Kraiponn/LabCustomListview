package com.ksn.kraiponn.lablistui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.dialog.InputDialog;
import com.ksn.kraiponn.lablistui.dialog.SingleChoiceDialogTemplate;

public class MainFragment extends Fragment {
    private Button btnChecked;
    private Button btnLogin;

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_main,
                container, false
        );

        initInstance(view);
        return view;
    }

    private void initInstance(View view) {
        btnChecked = view.findViewById(R.id.btn_checked);
        btnLogin = view.findViewById(R.id.btn_login);
        btnChecked.setOnClickListener(buttonCheckedClickListener);
        btnLogin.setOnClickListener(btnLoginClickedListener);
    }

    private void initInflate() {

    }


    /*******************************
     *      Listener Zone
     *****************************/
    View.OnClickListener buttonCheckedClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            InputDialog dialog = InputDialog.newInstance(
                    "Edter Data",
                    "",
                    InputDialog.DataType.String
            );

            dialog.show(fm, null);
            dialog.setOnFinishDialogListener(new InputDialog.onFinishDialogListener() {
                @Override
                public void onFinishDialog(String inputResult) {
                    //
                }
            });
        }
    };

    View.OnClickListener btnLoginClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //
        }
    };




}
