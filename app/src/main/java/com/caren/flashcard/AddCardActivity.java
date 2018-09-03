package com.caren.flashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {
    public static final String QUESTION_KEY = "question";
    public static final String WRONG_ANSWER_1_KEY = "wrong_answer_1";
    public static final String WRONG_ANSWER_2_KEY = "wrong_answer_2";
    public static final String CORRECT_ANSWER_KEY = "correct_answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.question_entry)).getText().toString();
                String wrongAnswer1 = ((EditText) findViewById(R.id.answer_entry_1)).getText().toString();
                String wrongAnswer2 = ((EditText) findViewById(R.id.answer_entry_2)).getText().toString();
                String correctAnswer = ((EditText) findViewById(R.id.correct_answer_entry)).getText().toString();

                Intent intent = new Intent();
                intent.putExtra(QUESTION_KEY, question);
                intent.putExtra(WRONG_ANSWER_1_KEY, wrongAnswer1);
                intent.putExtra(WRONG_ANSWER_2_KEY, wrongAnswer2);
                intent.putExtra(CORRECT_ANSWER_KEY, correctAnswer);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
