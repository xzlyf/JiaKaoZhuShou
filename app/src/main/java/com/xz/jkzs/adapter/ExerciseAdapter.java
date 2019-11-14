package com.xz.jkzs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xz.jkzs.R;
import com.xz.jkzs.entity.TikuListEntity;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private Context mContext;
    private List<TikuListEntity> mList;


    public ExerciseAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
    }

    public void refresh(List<TikuListEntity> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_exercise, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!mList.get(position).getPic().equals("")) {
//            Picasso.get().load(mList.get(position).getPic()).into(holder.pic);
            Glide.with(mContext).load(mList.get(position).getPic()).into(holder.pic);

        }
        holder.option1.setText(mList.get(position).getOption1());
        holder.option2.setText(mList.get(position).getOption2());
        holder.option3.setText(mList.get(position).getOption3());
        holder.option4.setText(mList.get(position).getOption4());
        holder.tips.setText(mList.get(position).getExplain());
        holder.question.setText(mList.get(position).getQuestion());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        CheckBox option1;
        CheckBox option2;
        CheckBox option3;
        CheckBox option4;
        TextView tips;
        TextView question;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            tips = itemView.findViewById(R.id.tips);
            question = itemView.findViewById(R.id.question);

        }
    }
}
