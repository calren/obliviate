package com.caren.flashcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView questionText;

    boolean mIsDisplayingAnswer = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = findViewById(R.id.question_text);
        questionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsDisplayingAnswer) {
                    questionText.setText(getResources().getString(R.string.question_1));
                    questionText.setBackgroundColor(getResources().getColor(R.color.question_background_color, null));
                    mIsDisplayingAnswer = false;
                } else {
                    questionText.setText(getResources().getString(R.string.question_1_answer));
                    questionText.setBackgroundColor(getResources().getColor(R.color.answer_background_color, null));
                    mIsDisplayingAnswer = true;
                }
            }
        });
    }
}
