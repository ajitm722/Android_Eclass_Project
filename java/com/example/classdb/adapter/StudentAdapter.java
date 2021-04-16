package com.example.classdb.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdb.R;
import com.example.classdb.activity.UpdateStudentActivity;
import com.example.classdb.db.DBHelper;
import com.example.classdb.model.Student;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentVH>{

    ArrayList<Student> students;
    Context context;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_student,parent,false);//for the cards
        StudentVH svh = new StudentVH(view);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentVH holder, int position) {
        final Student s = students.get(position);
        holder.tvName.setText(s.getName());
        holder.tvCourse.setText(s.getCourse());
        holder.tvRollNo.setText(s.getRollno());
        holder.tvTotalF.setText(String.valueOf(s.getTotal()));
        holder.tvPaid.setText(String.valueOf(s.getPaid()));

        holder.cardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,s.getName()+" will be updated",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, UpdateStudentActivity.class);
                intent.putExtra("STUDENT",s);


                context.startActivity(intent);
            }
        });

        holder.cardDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,s.getName()+" will be deleted",Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("CONFIRM");
                builder.setMessage("ARE YOU SURE?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBHelper dbHelper = new DBHelper(context);
                        int result = dbHelper.deleteStudent(s.getId());
                        if(result>0){
                            Toast.makeText(context,"DELETED",Toast.LENGTH_SHORT).show();
                            students.remove(s);
                            notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(context,"FAILED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("NO",null);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentVH extends RecyclerView.ViewHolder{

        TextView tvName,tvCourse,tvRollNo,tvTotalF,tvPaid;
        CardView cardUpdate,cardDelete;
        public StudentVH(@NonNull View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            tvCourse = v.findViewById(R.id.tvCourse);
            tvRollNo = v.findViewById(R.id.tvRollNo);
            tvPaid = v.findViewById(R.id.tvFeePaid);
            tvTotalF = v.findViewById(R.id.tvTotalFee);

            cardUpdate = v.findViewById(R.id.cardUpdate);
            cardDelete = v.findViewById(R.id.cardDelete);
        }
    }
}
