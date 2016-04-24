package com.marssim;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
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
                        updateViews();
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 100);

    }

    private void updateViews(){
        // time
        TextView tt1 = (TextView) findViewById(R.id.textViewTime);
        tt1.setText(gameState.getTimeString());

        Astronaut astronaut = gameState.getAstronaut();
        BaseResources baseResources = gameState.getBaseResources();

        updateProgressBar(R.id.progressBarEntertainment, astronaut.getEntertainmentLevel());
        updateProgressBar(R.id.progressBarHealth, astronaut.getHealth());
        updateProgressBar(R.id.progressBarRest, astronaut.getWellRested());
        updateProgressBar(R.id.progressBarSatiety, astronaut.getSatiety());

        updateResourcesWithProp(R.id.textViewEnergy, R.id.progressBarEnergy, baseResources.getEnergy());
        updateResourcesWithProp(R.id.textViewFood, R.id.progressBarFood, baseResources.getFood());
        updateResourcesWithProp(R.id.textViewOxygen, R.id.progressBarOxygen, baseResources.getOxygen());
        updateResourcesWithProp(R.id.textViewDevelopment, R.id.progressBarDevelopment, baseResources.getTechnologyPoints());
        updateResourcesWithProp(R.id.textViewWater, R.id.progressBarWater, baseResources.getWater());
    }

    private void updateResourcesWithProp(int textViewId, int progressBarId, Property prop){
        updateProgressBar(progressBarId, prop);
        updateTextView(textViewId, prop);
    }

    private void updateTextView(int id, Property prop){
        TextView tv = (TextView) findViewById(id);
        StringBuilder sb = new StringBuilder();
        sb.append((int) prop.getValue());
        sb.append('/');
        sb.append((int) prop.getMax());
        tv.setText(sb.toString());
    }

    private void updateProgressBar(int id, Property prop){
        ProgressBar pb = (ProgressBar) findViewById(id);
        pb.setMax((int) prop.getMax());
        pb.setProgress((int) prop.getValue());
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
