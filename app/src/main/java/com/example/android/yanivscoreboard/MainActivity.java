package com.example.android.yanivscoreboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.yanivscoreboard.R.id.editText1;
import static com.example.android.yanivscoreboard.R.id.editText2;
import static com.example.android.yanivscoreboard.R.id.editText3;
import static com.example.android.yanivscoreboard.R.id.editText4;

public class MainActivity extends AppCompatActivity {

    int scoreP1 = 0;
    int scoreP2 = 0;
    int scoreP3 = 0;
    int scoreP4 = 0;
    int YanivFlag1;
    int YanivFlag2;
    int YanivFlag3;
    int YanivFlag4;
    int assafFlag1;
    int assafFlag2;
    int assafFlag3;
    int assafFlag4;
    int val1;
    int val2;
    int val3;
    int val4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void yaniv() {
        if (YanivFlag1 == 1) {
            if (assafFlag2 == 1 || assafFlag3 == 1 || assafFlag4 == 1)
                scoreP1 += 30;
            else
                scoreP1 -= val1;
        }
        if (YanivFlag2 == 1) {
            if (assafFlag1 == 1 || assafFlag3 == 1 || assafFlag4 == 1)
                scoreP2 += 30;
            else
                scoreP2 -= val2;
        }
        if (YanivFlag3 == 1) {
            if (assafFlag1 == 1 || assafFlag2 == 1 || assafFlag4 == 1)
                scoreP3 += 30;
            else
                scoreP3 -= val3;
        }
        if (YanivFlag4 == 1) {
            if (assafFlag1 == 1 || assafFlag2 == 1 || assafFlag3 == 1)
                scoreP4 += 30;
            else
                scoreP4 -= val4;
        }

    }

    public int activateYanivFlag1(View v) {
        YanivFlag1 = 1;
        return YanivFlag1;
    }

    public int activateYanivFlag2(View v) {
        YanivFlag2 = 1;
        return YanivFlag2;
    }

    public int activateYanivFlag3(View v) {
        YanivFlag3 = 1;
        return YanivFlag3;
    }

    public int activateYanivFlag4(View v) {
        YanivFlag4 = 1;
        return YanivFlag4;
    }

    public int activateAssafFlag1(View v) {
        assafFlag1 = 1;
        val1 = 0;
        return assafFlag1;
    }

    public int activateAssafFlag2(View v) {
        assafFlag2 = 1;
        val2 = 0;
        return assafFlag2;
    }

    public int activateAssafFlag3(View v) {
        assafFlag3 = 1;
        val3 = 0;
        return assafFlag3;
    }

    public int activateAssafFlag4(View v) {
        assafFlag4 = 1;
        val4 = 0;
        return assafFlag4;
    }

    public void isBonus() {
        if (scoreP1 == 50 || scoreP1 == 100 || scoreP1 == 150 || scoreP1 == 200)
            scoreP1 /= 2;
        if (scoreP2 == 50 || scoreP2 == 100 || scoreP2 == 150 || scoreP2 == 200)
            scoreP2 /= 2;
        if (scoreP3 == 50 || scoreP3 == 100 || scoreP3 == 150 || scoreP3 == 200)
            scoreP3 /= 2;
        if (scoreP4 == 50 || scoreP4 == 100 || scoreP4 == 150 || scoreP4 == 200)
            scoreP4 /= 2;
    }

    public void submit(View v) {
        EditText p1CurrentScore = (EditText) findViewById(editText1);
        val1 = Integer.parseInt(p1CurrentScore.getText().toString());
        EditText p2CurrentScore = (EditText) findViewById(editText2);
        val2 = Integer.parseInt(p2CurrentScore.getText().toString());
        EditText p3CurrentScore = (EditText) findViewById(editText3);
        val3 = Integer.parseInt(p3CurrentScore.getText().toString());
        EditText p4CurrentScore = (EditText) findViewById(editText4);
        val4 = Integer.parseInt(p4CurrentScore.getText().toString());
        scoreP1 += val1;
        scoreP2 += val2;
        scoreP3 += val3;
        scoreP4 += val4;
        yaniv();
        isBonus();
        displayScore(scoreP1, scoreP2, scoreP3, scoreP4);
        val1 = 0;
        val2 = 0;
        val3 = 0;
        val4 = 0;
        YanivFlag1 = 0;
        YanivFlag2 = 0;
        YanivFlag3 = 0;
        YanivFlag4 = 0;
        assafFlag1 = 0;
        assafFlag2 = 0;
        assafFlag3 = 0;
        assafFlag4 = 0;
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScore(int score1, int score2, int score3, int score4) {
        TextView scoreView1 = (TextView) findViewById(R.id.p1_score);
        scoreView1.setText(String.valueOf(score1));
        TextView scoreView2 = (TextView) findViewById(R.id.p2_score);
        scoreView2.setText(String.valueOf(score2));
        TextView scoreView3 = (TextView) findViewById(R.id.p3_score);
        scoreView3.setText(String.valueOf(score3));
        TextView scoreView4 = (TextView) findViewById(R.id.p4_score);
        scoreView4.setText(String.valueOf(score4));
    }

    public void resetScore(View v) {
        val1 = 0;
        val2 = 0;
        val3 = 0;
        val4 = 0;
        YanivFlag1 = 0;
        YanivFlag2 = 0;
        YanivFlag3 = 0;
        YanivFlag4 = 0;
        assafFlag1 = 0;
        assafFlag2 = 0;
        assafFlag3 = 0;
        assafFlag4 = 0;
        scoreP1 = 0;
        scoreP2 = 0;
        scoreP3 = 0;
        scoreP4 = 0;
        displayScore(scoreP1, scoreP2, scoreP3, scoreP4);
    }

}