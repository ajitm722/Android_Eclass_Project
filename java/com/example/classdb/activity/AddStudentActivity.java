package com.example.classdb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classdb.R;
import com.example.classdb.db.DBHelper;
import com.example.classdb.model.Student;

public class AddStudentActivity extends AppCompatActivity {
    //we download text inputlayout for the special effects

    EditText edName,edCourse,edRollNo,edTotalFee,edFeePaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edName = findViewById(R.id.edName);
        edCourse = findViewById(R.id.edCourse);
        edRollNo = findViewById(R.id.edRollNo);
        edTotalFee = findViewById(R.id.edTotalFee);
        edFeePaid = findViewById(R.id.edFeePaid);
    }
    //we jump to display all activity if user presses showAll
    public void showAll(View view) {
        startActivity(new Intent(AddStudentActivity.this,StudentListActivity.class));
    }
    public void tcq(View view) {
        startActivity(new Intent(AddStudentActivity.this,MainActivity.class));
    }
    public void courses(View view) {
        startActivity(new Intent(AddStudentActivity.this,Courses.class));
    }


    public void save(View view) {
        String name = edName.getText().toString().trim();
        String course = edCourse.getText().toString().trim();
        String rollno = edRollNo.getText().toString().trim();
        String total = edTotalFee.getText().toString().trim();
        String paid = edFeePaid.getText().toString().trim();

        DBHelper dbHelper = new DBHelper(AddStudentActivity.this);

        Student s = new Student(name,course,rollno,Integer.parseInt(total),Integer.parseInt(paid));
        long result = dbHelper.addStudent(s);

        if(result>0)
        {
            Toast.makeText(this,"Student added to course!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Failed"+result,Toast.LENGTH_SHORT).show();
        }
    }
}