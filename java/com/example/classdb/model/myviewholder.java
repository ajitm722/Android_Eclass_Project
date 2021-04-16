package com.example.classdb.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdb.R;

public class myviewholder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView t1,t2;
    public myviewholder(@NonNull View itemView) {
        super(itemView);
        img = (ImageView)itemView.findViewById(R.id.img1);
        t1 = (TextView)itemView.findViewById(R.id.t1);
        t2 = (TextView)itemView.findViewById(R.id.t2);
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getT1() {
        return t1;
    }

    public void setT1(TextView t1) {
        this.t1 = t1;
    }

    public TextView getT2() {
        return t2;
    }

    public void setT2(TextView t2) {
        this.t2 = t2;
    }
}
