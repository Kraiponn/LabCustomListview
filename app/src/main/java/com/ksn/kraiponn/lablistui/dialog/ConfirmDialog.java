package com.ksn.kraiponn.lablistui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class ConfirmDialog extends DialogFragment {

    public enum BUTTON {
        Negative, Positive
    }

    public interface onFinishDialogListener{
        void onFinishDialog(ConfirmDialog.BUTTON button);
    }

    private onFinishDialogListener mListener;

    public ConfirmDialog(){}

    public static ConfirmDialog newInstance(
            String msg, String negItem, String posItem
    ) {
        ConfirmDialog dialog = new ConfirmDialog();
        Bundle args = new Bundle();
        args.putString("msg", msg);
        args.putString("negItem", negItem);
        args.putString("posItem", posItem);
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
        String negItem = getArguments().getString("negItem");
        String posItem = getArguments().getString("posItem");

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
                .setMessage(msg)
                .setNegativeButton(negItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(BUTTON.Negative);
                    }
                })
                .setPositiveButton(posItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(BUTTON.Positive);
                    }
                });

        return alert.create();
    }
    
}
