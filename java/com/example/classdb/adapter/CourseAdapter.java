package com.example.classdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdb.R;
import com.example.classdb.model.CourseModel;
import com.example.classdb.model.myviewholder;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<myviewholder> {

    ArrayList<CourseModel>data;

    public CourseAdapter(ArrayList<CourseModel> data) {

        this.data = data;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_course,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.getT1().setText(data.get(position).getHeader());
        holder.getT2().setText(data.get(position).getDesc());
        holder.getImg().setImageResource(data.get(position).getImgname());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
