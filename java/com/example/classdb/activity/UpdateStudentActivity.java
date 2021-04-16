package com.example.classdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classdb.R;
import com.example.classdb.db.DBHelper;
import com.example.classdb.model.Student;

public class UpdateStudentActivity extends AppCompatActivity {

    EditText edName,edCourse,edRollNo,edTotalFee,edFeePaid;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        Student s = (Student) getIntent().getExtras().getSerializable("STUDENT");

        id = s.getId();
        edName = findViewById(R.id.edName);
        edCourse = findViewById(R.id.edCourse);
        edRollNo = findViewById(R.id.edRollNo);
        edTotalFee = findViewById(R.id.edTotalFee);
        edFeePaid = findViewById(R.id.edFeePaid);

        edName.setText(s.getName());
        edCourse.setText(s.getCourse());
        edRollNo.setText(s.getRollno());
        edTotalFee.setText(String.valueOf(s.getTotal()));
        edFeePaid.setText(String.valueOf(s.getPaid()));
    }

    public void update(View view) {
        String name = edName.getText().toString().trim();
        String course = edCourse.getText().toString().trim();
        String rollno = edRollNo.getText().toString().trim();
        String total = edTotalFee.getText().toString().trim();
        String paid = edFeePaid.getText().toString().trim();

        Student s = new Student(id,name,course,rollno,Integer.parseInt(total),Integer.parseInt(paid));
        DBHelper dbHelper = new DBHelper(this);
        int result = dbHelper.updateStudent(s);

        if(result>0)
        {
            Toast.makeText(this,"Updated"+result,Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this,"Failed"+result,Toast.LENGTH_SHORT).show();
        }
    }
}