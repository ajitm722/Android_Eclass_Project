package com.example.classdb.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdb.R;
import com.example.classdb.adapter.CourseAdapter;
import com.example.classdb.model.CourseModel;

import java.util.ArrayList;

public class Courses extends AppCompatActivity {

    RecyclerView rcv;
    CourseAdapter adapter;
    CardView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        setTitle("COURSE LIST");
        rcv = (RecyclerView)findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CourseAdapter(dataqueue());
        rcv.setAdapter(adapter);
    }
    public ArrayList<CourseModel> dataqueue(){
        ArrayList<CourseModel> holder = new ArrayList<>();
        CourseModel ob1 = new CourseModel();
        ob1.setHeader("C++ Cost:100");
        ob1.setDesc("C++ is a cross-platform language that can be used to create high-performance applications.\n" +
                "\n" +
                "C++ was developed by Bjarne Stroustrup, as an extension to the C language.\n" +
                "\n" +
                "C++ gives programmers a high level of control over system resources and memory.\n" +
                "\n" +
                "The language was updated 3 major times in 2011, 2014, and 2017 to C++11, C++14, and C++17.");
        ob1.setImgname(R.drawable.programa);
        holder.add(ob1);
        CourseModel ob2 = new CourseModel();
        ob2.setHeader("Java Cost:100");
        ob2.setDesc("Java is a programming language created by James Gosling from Sun Microsystems (Sun) in 1991." +
                " The target of Java is to write a program once and then run this program on multiple operating systems." +
                        "Java is defined by a specification and consists of a programming language, a compiler, core libraries" +
                        " and a runtime (Java virtual machine) The Java runtime allows software developers to write program code" +
                        " in other languages than the Java programming language which still runs on the Java virtual machine. ");
        ob2.setImgname(R.drawable.programb);
        holder.add(ob2);
        CourseModel ob3 = new CourseModel();
        ob3.setHeader("Python Cost:200");
        ob3.setDesc("Python is a popular programming language. It was created by Guido van Rossum, and released in 1991.\n" +
                "\n" +
                "It is used for:\n" +
                "\n" +
                "web development (server-side),\n" +
                "software development,\n" +
                "mathematics/machine learning,\n" +
                "system scripting. ");
        ob3.setImgname(R.drawable.programc);
        holder.add(ob3);
        CourseModel ob4 = new CourseModel();
        ob4.setHeader("JavaScript Cost:500");
        ob4.setDesc("JavaScript is used mainly for enhancing the interaction of a user with the webpage. " +
                "In other words, you can make your webpage more lively and interactive, with the help of JavaScript." +
                " JavaScript is also being used widely in game development and Mobile application development.\n");
        ob4.setImgname(R.drawable.programd);
        holder.add(ob4);
        return holder;
    }
}
