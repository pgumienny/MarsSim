package com.marssim.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marssim.Astronaut;
import com.marssim.BaseResources;
import com.marssim.GameState;
import com.marssim.Property;
import com.marssim.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Franek on 2016-04-24.
 */
public class GameStateActivity extends Activity {
    GameState gameState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameState = GameState.getGameState();

        setContentView(R.layout.base_resources_layout);

        Button btnReturn = (Button) findViewById(R.id.buttonReturn);

        Intent i = getIntent();

        // Binding Click event to Button
        btnReturn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                finish();
            }
        });

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
        if(tt1 != null) {
            tt1.setText(gameState.getTimeString());
        }

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
        updateResourcesWithProp(R.id.textViewHydrogen, R.id.progressBarHydrogen, baseResources.getHydrogen());

    }

    private void updateProgressBar(int id, Property prop){
        ProgressBar pb = (ProgressBar) findViewById(id);
        if(pb == null) return;
        pb.setMax((int) prop.getMax());
        pb.setProgress((int) prop.getValue());
    }

    private void updateResourcesWithProp(int textViewId, int progressBarId, Property prop){
        updateProgressBar(progressBarId, prop);
        updateTextView(textViewId, prop);
    }

    private void updateTextView(int id, Property prop){
        TextView tv = (TextView) findViewById(id);
        if(tv == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((int) prop.getValue());
        sb.append("/");
        sb.append((int) prop.getMax());
        tv.setText(sb.toString());
    }
}
