package com.ksn.kraiponn.lablistui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class SingleChoiceDialogTemplate extends DialogFragment {
    private int mSelectIndex = -1;

    public SingleChoiceDialogTemplate() {
        super();
    }

    public static SingleChoiceDialogTemplate newInstance(
            String title, String[] items
    ) {
        SingleChoiceDialogTemplate dialog = new SingleChoiceDialogTemplate();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putStringArray("items", items);
        dialog.setArguments(args);

        return dialog;
    }

    public interface onFinishDialogListener {
        void onFinishDialog(int selectIndex);
    }

    private onFinishDialogListener mListener;

    public void onSetFinishListener(onFinishDialogListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        String[] items = getArguments().getStringArray("items");

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setSingleChoiceItems(items, mSelectIndex,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSelectIndex = which;
                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(-1);
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(mSelectIndex);
                    }
                });

        return dialog.create();
    }

}
