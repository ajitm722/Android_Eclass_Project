package com.example.classdb.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdb.R;
import com.example.classdb.adapter.StudentAdapter;
import com.example.classdb.db.DBHelper;
import com.example.classdb.model.Student;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {
    DBHelper dbHelper;
    TextView tvTotal;
    RecyclerView recyclerView;
    ArrayList<Student> students;
    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        tvTotal = findViewById(R.id.tvTotal);
        recyclerView = findViewById(R.id.recyclerView);

        dbHelper = new DBHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        students = dbHelper.getAllStudents();
        tvTotal.setText("Students List:");

        studentAdapter = new StudentAdapter(students,this);
        recyclerView.setAdapter(studentAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }
}