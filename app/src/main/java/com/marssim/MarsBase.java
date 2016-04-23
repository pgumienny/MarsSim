package com.marssim;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MarsBase extends AppCompatActivity {
    GameState gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_base);

        restoreState();

        if (gameState == null) {
            gameState = new GameState();
        }

        final Handler handler = new Handler();
        Timer timer = new Timer(false);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameState.tick();
                        TextView tt1 = (TextView) findViewById(R.id.textViewTime);
                        tt1.setText(gameState.getTimeString());
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 100);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        saveState();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        saveState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveState();
    }

    private void saveState(){
        Persistence.writeObjectToFile(getApplicationContext(), gameState, Const.GAME_PACKAGE);
    }

    private void restoreState(){
        gameState = (GameState) Persistence.readObjectFromFile(getApplicationContext(), Const.GAME_PACKAGE);
    }
}
