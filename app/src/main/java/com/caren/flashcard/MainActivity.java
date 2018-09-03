package com.caren.flashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;

    private TextView questionText;
    private TextView answerText1;
    private TextView answerText2;
    private TextView answerText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.question_text);
        answerText1 = findViewById(R.id.answer_1);
        answerText2 = findViewById(R.id.answer_2);
        answerText3 = findViewById(R.id.answer_3);

        questionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionText.setText("Barack Obama");
            }
        });

        findViewById(R.id.add_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddCardActivityIntent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(startAddCardActivityIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String question = data.getStringExtra(AddCardActivity.QUESTION_KEY);
            String wrongAnswer1 = data.getStringExtra(AddCardActivity.WRONG_ANSWER_1_KEY);
            String wrongAnswer2 = data.getStringExtra(AddCardActivity.WRONG_ANSWER_2_KEY);
            String correctAnswer = data.getStringExtra(AddCardActivity.CORRECT_ANSWER_KEY);

            questionText.setText(question);
            answerText1.setText(wrongAnswer1);
            answerText2.setText(wrongAnswer2);
            answerText3.setText(correctAnswer);
        }
    }
}
