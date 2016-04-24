package com.marssim;

import android.content.Intent;
import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marssim.views.RoomView;


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
        setButtonListenerGreenHouse();

    }

    private void setButtonListenerGreenHouse(){

        final ImageButton btnGreenHouse = (ImageButton)findViewById(R.id.imageButtonGreenhouse);

        // Set up onClick listeners for buttons to send 1 or 0 to turn on/off LED
        btnGreenHouse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent act2 = new Intent(v.getContext(),RoomView.class);
                startActivity(act2);
            }
        });
    }

    private void updateViews(){
        // time
        TextView tt1 = (TextView) findViewById(R.id.textViewTime);
        tt1.setText(gameState.getTimeString());

        Astronaut astronaut = gameState.getAstronaut();

        updateProgressBar(R.id.progressBarEntertainment, astronaut.getEntertainmentLevel());
        updateProgressBar(R.id.progressBarHealth, astronaut.getHealth());
        updateProgressBar(R.id.progressBarRest, astronaut.getWellRested());
        updateProgressBar(R.id.progressBarSatiety, astronaut.getSatiety());

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
