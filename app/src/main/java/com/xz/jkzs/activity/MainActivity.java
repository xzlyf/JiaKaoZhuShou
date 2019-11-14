package com.xz.jkzs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.shawnlin.numberpicker.NumberPicker;
import com.xz.jkzs.R;
import com.xz.jkzs.base.BaseActivity;
import com.xz.xzwidget.dialog.XOnClickListener;
import com.xz.xzwidget.dialog.XzTipsDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tpye_picker)
    NumberPicker tpyePicker;
    @BindView(R.id.subject_picker)
    NumberPicker subjectPicker;
    @BindView(R.id.select_plane)
    LinearLayout selectPlane;
    @BindView(R.id.submit)
    Button submit;
    private String[] data = {"A1", "A3", "B1", "A2", "B2", "C1", "C2", "C3", "D", "E", "F"};
    private String[] data2 = {"一", "四"};
    private CharSequence type = data[5];
    private CharSequence subject = data2[0];
    private XzTipsDialog mDialog;

    @Override
    public boolean homeAsUpEnabled() {
        return false;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

        tpyePicker.setMinValue(1);
        tpyePicker.setMaxValue(data.length);
        tpyePicker.setDisplayedValues(data);
        tpyePicker.setValue(6);
        subjectPicker.setMinValue(1);
        subjectPicker.setMaxValue(data2.length);
        subjectPicker.setDisplayedValues(data2);
        subjectPicker.setValue(1);
        tpyePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                type = data[newVal - 1];
            }
        });
        subjectPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                subject = data2[newVal - 1];
            }
        });


    }

    @OnClick(R.id.submit)
    public void submit() {

        mDialog = new XzTipsDialog.Builder(this)
                .setContent("\n\n选择" + type.toString() + "科目" + subject.toString() + "题库\n\n")
                .setCancelOnclickListener("重选", new XOnClickListener() {
                    @Override
                    public void onClick(int viewId, String s, int position) {

                    }
                })
                .setSubmitOnClickListener("确定", new XOnClickListener() {
                    @Override
                    public void onClick(int viewId, String s, int position) {
                        startActivity(new Intent(MainActivity.this, ExerciseActivity.class)
                                .putExtra("type", type.toString())
                                .putExtra("subject", subject.toString()));
                        mDialog.dismiss();
                    }
                })
                .create();
        mDialog.show();
    }

}
