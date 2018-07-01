package com.ksn.kraiponn.lablistui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ksn.kraiponn.lablistui.R;

public class InputDialog extends DialogFragment {

    public enum DataType{
        String, Number, Password
    }

    public interface onFinishDialogListener{
        void onFinishDialog(String inputResult);
    }

    private onFinishDialogListener mListener;

    public InputDialog(){}

    public static InputDialog newInstance(
            String msg, String defaultValue,
            DataType type
    ) {
        InputDialog dialog = new InputDialog();
        Bundle args = new Bundle();
        args.putString("msg", msg);
        args.putString("defaultValue", defaultValue);
        args.putSerializable("type", type);
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
        String defaultValue = getArguments().getString("defaultValue");
        DataType type = (DataType)
                getArguments().getSerializable("type");

        View view = getActivity().getLayoutInflater().inflate(
                R.layout.input_dialog_layout,
                null);
        TextView tv = view.findViewById(R.id.text_topic_dialog);
        final EditText edtInput = view.findViewById(R.id.edit_input_dialog);

        tv.setText(msg);
        if (type == DataType.String) {
            edtInput.setInputType(InputType.TYPE_CLASS_TEXT);
        } else if (type == DataType.Number) {
            edtInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        } else if (type == DataType.Password) {
            edtInput.setInputType(
                    InputType.TYPE_TEXT_VARIATION_PASSWORD|
                    InputType.TYPE_CLASS_TEXT
            );
        }
        edtInput.setText(defaultValue);

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onFinishDialog(
                                edtInput.getText().toString()
                        );
                    }
                });

        return alert.create();
    }

}
