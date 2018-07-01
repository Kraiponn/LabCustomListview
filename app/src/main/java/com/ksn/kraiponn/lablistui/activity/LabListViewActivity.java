package com.ksn.kraiponn.lablistui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ksn.kraiponn.lablistui.R;
import com.ksn.kraiponn.lablistui.dialog.ConfirmDialog;
import com.ksn.kraiponn.lablistui.dialog.InputDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class LabListViewActivity extends AppCompatActivity {

    /**************************
     * -- Valriable
     ************************/
    private Toolbar toolbar;
    private ImageView imgBack;
    private ImageView imgAdd;
    private ImageView imgEdit;
    private EditText edtFilter;
    private ImageView imgDelete;
    private ListView mListView;
    private ArrayList<String> mArrList = new ArrayList<>();
    private ArrayAdapter<String> mArrAdapter;
    private String[] items;
    private final int ADD = 1;
    private final int EDIT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_list_view);
        initInstance();
        if (savedInstanceState == null) {
            //
        }
    }


    /**************************
     * -- Method And Function
     ************************/
    private void initInstance() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        edtFilter = findViewById(R.id.edit_filter);
        imgBack = findViewById(R.id.image_back);
        imgAdd = findViewById(R.id.image_add);
        imgEdit = findViewById(R.id.image_edit);
        imgDelete = findViewById(R.id.image_delete);
        mListView = findViewById(R.id.list_view_lab);

        items = new String[] {
                "Mobile", "Android", "IOS", "Windows", "Symbian",
                "Web Site", "Node JS", "PHP Laravel", "ASP.Net",
                "Angular 5+", "React JS", "Vue JS", "Jquery",
                "Embedded", "MCS 51", "PIC", "AVR", "Arduino", "Node MCU",
                "Graphic Design", "Photoshop", "Illustrator", "After Effect",
                "Protel", "Proteus", "P Spice", "Rasberry PI"
        };

        mArrList.addAll(Arrays.asList(items));
        setListViewAdapter();

        imgDelete.setOnClickListener(imgDeleteClickedListener);
        imgEdit.setOnClickListener(imgEditClickedListener);
        imgAdd.setOnClickListener(imgAddClickedListener);
        imgBack.setOnClickListener(imgBackClickedListener);
        edtFilter.addTextChangedListener(edtFilterTextChangeListener);
        mListView.setOnItemLongClickListener(listViewItemLongClickedListener);
    }

    private void setListViewAdapter() {
        mArrAdapter = new ArrayAdapter<>(
                getBaseContext(),
                android.R.layout.simple_list_item_checked,
                mArrList
        );

        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mListView.setAdapter(mArrAdapter);
    }

    private void showToast(String str) {
        Toast.makeText(getBaseContext(),
                str,
                Toast.LENGTH_SHORT).show();
    }

    private String getItemChecked(int pos) {
        String itemResult = mListView.getItemAtPosition(pos).toString();
        return itemResult;
    }

    private void showInputDialog(String title,
                                 String itemChecked,
                                 final int type) {
        FragmentManager fm = getSupportFragmentManager();
        InputDialog dialog = InputDialog.newInstance(
                title, itemChecked,
                InputDialog.DataType.String
        );

        dialog.show(fm, null);
        dialog.setOnFinishDialogListener(new InputDialog.onFinishDialogListener() {
            @Override
            public void onFinishDialog(String inputResult) {
                if (type == EDIT) {
                    int pos = mListView.getCheckedItemPosition();
                    if (pos < 0) {
                        showToast("Please select item for edit.");
                        return;
                    }

                    String str = getItemChecked(pos);
                    int nPos = mArrList.indexOf(str);
                    mArrList.set(pos, inputResult);
                    showToast("Edit data successfully.");
                } else if (type == ADD) {
                    mArrList.add(inputResult);
                    showToast("Add new item success.");
                }
            }
        });

        mArrAdapter.notifyDataSetChanged();
        //reFilter();
    }

    private void reFilter() {
        String str = edtFilter.getText().toString();
        if (str.trim().isEmpty()) {
            edtFilter.setText("");
            edtFilter.setText(str);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(
                R.anim.slide_in_left,
                R.anim.slide_out_right
        );
    }



    /**************************
     * -- Listener Zone
     ************************/
    TextWatcher edtFilterTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s,
                                      int start,
                                      int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s,
                                  int start,
                                  int before,
                                  int count) {
            String str = edtFilter.getText().toString();
            if (str.length() > 0) {
                mArrAdapter.getFilter().filter(str);
            } else {
                setListViewAdapter();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    View.OnClickListener imgBackClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setListViewAdapter();
            edtFilter.setText("");
        }
    };

    View.OnClickListener imgDeleteClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = mListView.getCheckedItemPosition();
            if (pos < 0) {
                showToast("Please choose item for delete.");
                return;
            }

            String itemSelect = getItemChecked(pos);
            mArrList.remove(itemSelect);
            mArrAdapter.notifyDataSetChanged();
            setListViewAdapter();
            showToast("Dlelete successfully");
        }
    };

    View.OnClickListener imgEditClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = mListView.getCheckedItemPosition();
            if (pos < 0) {
                showToast("Please select item for edit.");
                return;
            }

            showInputDialog(
                    "Please replace new data for edit item.",
                    getItemChecked(pos),
                    EDIT
            );
        }
    };


    View.OnClickListener imgAddClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showInputDialog(
                    "Please enter your data for added",
                    "",
                    ADD
            );
        }
    };

    AdapterView.OnItemLongClickListener listViewItemLongClickedListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent,
                                       View view,
                                       int position,
                                       long id) {
            mListView.setItemChecked(position, true);
            String itemSelected =
                    mListView.getItemAtPosition(position).toString();
            FragmentManager fm = getSupportFragmentManager();
            ConfirmDialog dialog = ConfirmDialog.newInstance(
                    "What do you want about this "
                            + itemSelected + " item",
                    "Delete", "Edit"
            );

            dialog.show(fm, null);
            dialog.setOnFinishDialogListener(new ConfirmDialog.onFinishDialogListener() {
                @Override
                public void onFinishDialog(ConfirmDialog.BUTTON button) {
                    if (button == ConfirmDialog.BUTTON.Negative) {
                        showToast("Delete item success");
                    } else if(button == ConfirmDialog.BUTTON.Positive) {
                        showToast("Edit item success");
                    }
                }
            });
            return true;
        }
    };

}
