package com.ksn.kraiponn.lablistui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class SingleChoiceDialog extends DialogFragment {

    private int mSelectIndex = -1;

    public interface onFinishDialogListener{
        void onFinishDialog(int selectedIndex);
    }

    private onFinishDialogListener mListener;

    public SingleChoiceDialog(){}

    public static SingleChoiceDialog newInstance(
            String msg, String[] items
    ) {
        SingleChoiceDialog dialog = new SingleChoiceDialog();
        Bundle args = new Bundle();
        args.putString("msg", msg);
        args.putStringArray("items", items);
        dialog.setArguments(args);
        return dialog;
    }

    public void setOnFinishDialogListener(onFinishDialogListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String msg = getArguments().getString("msg");
        String[] items = getArguments().getStringArray("items");

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext())
                .setMessage(msg)
                .setSingleChoiceItems(items, mSelectIndex,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSelectIndex = which;
                            }
                        })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(mSelectIndex);
                    }
                });

        return alert.create();
    }

}
