package com.xz.jkzs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.orhanobut.logger.Logger;
import com.squareup.okhttp.Request;
import com.xz.jkzs.R;
import com.xz.jkzs.adapter.ExerciseAdapter;
import com.xz.jkzs.base.BaseActivity;
import com.xz.jkzs.constant.Local;
import com.xz.jkzs.network.OkHttpClientManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseActivity extends BaseActivity {

    @BindView(R.id.exercise_Recycler)
    RecyclerView recycler;
    private String type;
    private String subject;
    private ExerciseAdapter adapter;

    @Override
    public boolean homeAsUpEnabled() {
        return true;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_exercise;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        subject = intent.getStringExtra("subject");
        initRecycler();

        //net_get();
    }

    private void initRecycler() {
        adapter = new ExerciseAdapter(this);
        List list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        adapter.refresh(list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
        // PagerSnapHelper每次只能滚动一个item;用LinearSnapHelper则可以一次滚动多个，并最终保证定位
        // mSnapHelper = new LinearSnapHelper();
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recycler);


    }

    /**
     * 获取题库题目
     */
    private void net_get() {
        showLoading("正在获取题库");
        Map<String, Object> params = new HashMap<>();
        params.put("appkey", Local.JDWX_KEY);
        params.put("type", type);
        if (subject.equals("一")) {
            params.put("subject", 1);
        } else if (subject.equals("二")) {
            params.put("subject", 2);
        }
        params.put("pagesize", 10);
        params.put("sort", "rand");
        params.put("pagenum", 1);

        OkHttpClientManager.getAsyn(this, Local.JD_WX_JIAKAOTIKU, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                Logger.w(request + "error:" + e.getMessage());
                disLoading();
            }

            @Override
            public void onResponse(String response) {
                Logger.w("题库" + response);
                disLoading();
            }

        }, params, true);

    }


}