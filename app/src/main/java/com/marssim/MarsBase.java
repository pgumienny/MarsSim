package com.marssim;

import android.content.Intent;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
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

import com.marssim.rooms.AbstractRoom;
import com.marssim.views.BaseActivity;
import com.marssim.views.RoomAcitivity;


public class MarsBase extends AppCompatActivity {
    GameState gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_base);


        restoreState();

        if (gameState == null) {
            gameState = GameState.getGameState();
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

        List<AbstractRoom> rooms = gameState.getRoomCollection().getRooms();

        for(int i = 0; i < rooms.size(); i++){
            setRoomListener(rooms.get(i).getButton(), i);
        }

    }

    private void setButtonListenerGreenHouse(){

        final ImageButton btnGreenHouse = (ImageButton)findViewById(R.id.imageButtonGreenhouse);


        Button btnNextScreen = (Button) findViewById(R.id.buttonRooms);

        //Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), RoomAcitivity.class);
                startActivity(nextScreen);

            }
        });

        Button baseButton = (Button) findViewById(R.id.buttonBase);

        baseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), BaseActivity.class);
                startActivity(nextScreen);
            }
        });



    }

    private void setRoomListener(int id, final int room_number){
        ImageButton button = (ImageButton) findViewById(id);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                GameState.getGameState().setCurrentRoomId(room_number);
                Intent nextScreen = new Intent(getApplicationContext(), RoomAcitivity.class);
                startActivity(nextScreen);
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
