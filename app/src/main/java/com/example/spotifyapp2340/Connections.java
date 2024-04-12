package com.example.spotifyapp2340;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.spotifyapp2340.QuestionAnswer;


public class Connections extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView7;
    private Button ans2, ansB2, ansC2, ansD2;
    private Button submitBtn7;
    private Button backBtn7;
    private EditText userAnswerEditText7;

    private int currentQuestionIndex6 = 0;

    private int score8 = 0;


    private static String choices2[][] = {
            {"One Dance","Rich Baby Daddy (feat. Sexyy Red & SZA)","IDGAF (feat. Yeat)","act ii: date @ 8 (feat. Drake) - remix"},
            {"Summertime Sadness","Say Yes To Heaven","Young and Beautiful","West Coast"},
            {"Paint The Town Red","Agora Hills","Woman","Kiss me More (feat. SZA)"}
    };

    private static String correctAnswers23[] = {
            "Drake",
            "Lana Del Rey",
            "Doja Cat"
    };

    void startGame(){
        ans2.setText(choices2[currentQuestionIndex6][0]);
        ansB2.setText(choices2[currentQuestionIndex6][1]);
        ansC2.setText(choices2[currentQuestionIndex6][2]);
        ansD2.setText(choices2[currentQuestionIndex6][3]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);

        ans2 = findViewById(R.id.ans_A);
        ansB2 = findViewById(R.id.ans_B);
        ansC2 = findViewById(R.id.ans_C);
        ansD2 = findViewById(R.id.ans_D);
        submitBtn7 = findViewById(R.id.submit_btn);
        backBtn7 = findViewById(R.id.back_btn);
        userAnswerEditText7 = findViewById(R.id.user_answer);

        startGame();

        // Set click listeners for buttons
        submitBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer();
            }
        });

        backBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Connections.this, MainActivity.class);
                startActivity(intent);
                // Optionally, call finish() if you want to remove this activity from the back stack
            }
        });
    }

    @Override
    public void onClick(View v) {
        submitBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer();
            }
        });

        backBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Connections.this, MainActivity.class);
                startActivity(intent);
                //finish();
            }
        });
    }

    void loadNewQuestion() {
        //if (currentQuestionIndex6 == 2) {
        //  finishQuiz();
        //return;
        //}

        ans2.setText(choices2[currentQuestionIndex6][0]);
        ansB2.setText(choices2[currentQuestionIndex6][1]);
        ansC2.setText(choices2[currentQuestionIndex6][2]);
        ansD2.setText(choices2[currentQuestionIndex6][3]);
    }

    private void verifyAnswer() {
        String userAnswer = userAnswerEditText7.getText().toString().trim();
        if(userAnswer.equalsIgnoreCase(correctAnswers23[currentQuestionIndex6])) {
            score8 = score8 + 1;
            // Show success message or proceed to next question
        }

        // Move to next question if any
        if (currentQuestionIndex6 < 2) {
            currentQuestionIndex6++;
            loadNewQuestion();
        } else {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setMessage("You got " + score8 + " correct!")
                    .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                    .setCancelable(false)
                    .create(); // Create the AlertDialog instance
            dialog.show(); // Show t
        }
    }
    void restartQuiz() {
        score8 = 0;
        currentQuestionIndex6 = 0;
        loadNewQuestion();
    }

}