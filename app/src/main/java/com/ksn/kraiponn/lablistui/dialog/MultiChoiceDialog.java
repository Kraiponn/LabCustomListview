package com.ksn.kraiponn.lablistui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class MultiChoiceDialog extends DialogFragment {

    private boolean[] mCheckedItem;

    public interface onFinishDialogListener{
        void onFinishDialog(boolean[] checkedItem);
    }

    private onFinishDialogListener mListener;

    public MultiChoiceDialog(){}

    public static MultiChoiceDialog newInstance(
            String title, String[] items
    ) {
        MultiChoiceDialog dialog = new MultiChoiceDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
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
        String title = getArguments().getString("title");
        String[] items = getArguments().getStringArray("items");
        mCheckedItem = new boolean[items.length];
        for (int i=0; i<mCheckedItem.length; i++) {
            mCheckedItem[i] = false;
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMultiChoiceItems(items, mCheckedItem,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which,
                                                boolean isChecked) {
                                mCheckedItem[which] = isChecked;
                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(mCheckedItem);
                    }
                });

        return alert.create();
    }

}
