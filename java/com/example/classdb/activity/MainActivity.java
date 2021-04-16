package com.example.classdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.classdb.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     Button falseButton;
     Button trueButton;
     TextView questionTextView;
     ImageButton nextButton;
     ImageButton prevButton;
     int currentQuestionIndex = 0;
     Question[] questionBank = new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5,true),
            new Question(R.string.question6,true),
            new Question(R.string.question7,true),
            new Question(R.string.question8,false),
            new Question(R.string.question9,true),
            new Question(R.string.question10,true),
            new Question(R.string.question11,true),
            new Question(R.string.question12,true),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        questionTextView = findViewById(R.id.answer_text_view);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next_button:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.prev_button:
                if(currentQuestionIndex>0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
                break;
        }
    }
    public void updateQuestion(){
        Log.d("Current","onClick:"+ currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }
    public void checkAnswer(boolean userChooseCorrect){
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId = 0;
        if(userChooseCorrect == answerIsTrue){
            toastMessageId = R.string.correct_answer;
        }
        else{
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(MainActivity.this,toastMessageId,Toast.LENGTH_SHORT).show();
    }
}