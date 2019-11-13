package com.xz.jkzs.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.xz.jkzs.MyApplication;
import com.xz.xzwidget.XType;
import com.xz.xzwidget.dialog.XOnClickListener;
import com.xz.xzwidget.dialog.XzLoadingDialog;
import com.xz.xzwidget.dialog.XzTipsDialog;
import com.xz.xzwidget.toast.XToast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Activity mContext;
    private XzLoadingDialog xzLoadingDialog;
    private XzTipsDialog xzTipsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        mContext = this;
        //设置是否开启返回homeAsUp按钮
        if (homeAsUpEnabled()) {
            ActionBar bar = getSupportActionBar();
            if (bar != null) {
                bar.setHomeButtonEnabled(true);
                bar.setDisplayHomeAsUpEnabled(true);

            }
        }
        initData();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束Activity&从集合中移除
        MyApplication.getInstance().finishActivity(this);
    }

    public abstract boolean homeAsUpEnabled();

    public abstract void initData();

    public abstract int getLayoutResource();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:  //id不要写错，前面要加android
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void showLoading(String text) {
        if (xzLoadingDialog == null) {
            xzLoadingDialog = new XzLoadingDialog.Builder(this)
                    .setCancelEnable(true)
                    .setCancelText(text)
                    .setCancelOnClickListener(new XOnClickListener() {
                        @Override
                        public void onClick(int viewId, String s, int position) {

                        }
                    })
                    .create();
        }

        xzLoadingDialog.show();
    }

    @Override
    public void disLoading() {
        if (xzLoadingDialog != null) {
            xzLoadingDialog.dismiss();
        }
    }

    @Override
    public void sToast(@NonNull String text) {
        XToast.showToast(this, text, XType.XTOAST_TYPE_TIPS);
    }

    @Override
    public void lToast(String text) {
        XToast.showToast(this, text, XType.XTOAST_TYPE_TIPS);

    }

    @Override
    public void sDialog(String msg) {
        if (xzTipsDialog == null) {
            xzTipsDialog = new XzTipsDialog.Builder(this)
                    .setContent(msg)
                    .setCancelOnclickListener("确定", new XOnClickListener() {
                        @Override
                        public void onClick(int viewId, String s, int position) {

                        }
                    })
                    .create();
        }
        xzTipsDialog.show();
    }

    @Override
    public void dDialog() {
        if (xzTipsDialog != null) {
            xzTipsDialog.dismiss();
        }
    }
}
