package com.example.deepamgoel.rockpaperscissor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final int ROCK = 0;
    private final int PAPER = 1;
    private final int SCISSORS = 2;
    int scoreA = 0, scoreB = 0;
    TextView scoreTextViewA;
    TextView scoreTextViewB;
    private ImageView mImageViewA;
    private ImageView mImageViewB;

    private static int generateRandomIntIntRange() {
        int min = 0, max = 2;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageViewA = findViewById(R.id.player_A_img);
        mImageViewB = findViewById(R.id.player_B_img);
        scoreTextViewA = findViewById(R.id.score_A);
        scoreTextViewB = findViewById(R.id.score_B);

    }

    public void run(View view) {
        int userA = generateRandomIntIntRange();
        int userB = Integer.valueOf((String) view.getTag());

        switch (userA) {
            case ROCK:
                mImageViewA.setImageResource(R.drawable.ic_rock);
                break;
            case PAPER:
                mImageViewA.setImageResource(R.drawable.ic_paper);
                break;
            case SCISSORS:
                mImageViewA.setImageResource(R.drawable.ic_scissors);
        }

        switch (userB) {
            case ROCK:
                mImageViewB.setImageResource(R.drawable.ic_rock);
                break;
            case PAPER:
                mImageViewB.setImageResource(R.drawable.ic_paper);
                break;
            case SCISSORS:
                mImageViewB.setImageResource(R.drawable.ic_scissors);
        }

        update(userA, userB);
    }

    private void update(int userA, int userB) {

        if ((userA == ROCK && userB == ROCK) || (userA == PAPER && userB == PAPER) || (userA == SCISSORS && userB == SCISSORS)) {

        } else if ((userA == ROCK && userB == SCISSORS) || (userA == PAPER && userB == ROCK) || (userA == SCISSORS && userB == PAPER)) {
            scoreA += 1;
            displayA(scoreA);
        } else if ((userB == ROCK && userA == SCISSORS) || (userB == PAPER && userA == ROCK) || (userB == SCISSORS && userA == PAPER)) {
            scoreB += 1;
            displayB(scoreB);
        }

        compare();
    }

    private void displayA(int score) {
        scoreTextViewA.setText(String.format(Locale.getDefault(), "%d", score));
    }

    private void displayB(int score) {
        scoreTextViewB.setText(String.format(Locale.getDefault(), "%d", score));
    }

    private void compare() {
        if (scoreA == 0 && scoreB == 0) {
            scoreTextViewA.setTextColor(Color.WHITE);
            scoreTextViewB.setTextColor(Color.WHITE);

        } else if (scoreA > scoreB) {
            scoreTextViewA.setTextColor(Color.GREEN);
            scoreTextViewB.setTextColor(Color.RED);

        } else if (scoreA < scoreB) {
            scoreTextViewA.setTextColor(Color.RED);
            scoreTextViewB.setTextColor(Color.GREEN);

        } else if (scoreA == scoreB) {
            scoreTextViewA.setTextColor(Color.CYAN);
            scoreTextViewB.setTextColor(Color.CYAN);

        }
    }

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        compare();
        mImageViewA.setImageResource(R.drawable.ic_rock);
        mImageViewB.setImageResource(R.drawable.ic_rock);

    }
}
