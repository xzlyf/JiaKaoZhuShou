package com.xz.jkzs.base;

public interface BaseView {
    void showLoading(String text);
    void disLoading();
    void sToast(String text);
    void lToast(String text);
    void sDialog(String msg);
    void dDialog();
}
