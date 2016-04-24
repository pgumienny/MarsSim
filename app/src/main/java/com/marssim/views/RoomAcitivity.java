package com.marssim.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marssim.Astronaut;
import com.marssim.GameState;
import com.marssim.Property;
import com.marssim.R;


/**
 * Created by pg on 23/04/16.
 */



public class RoomAcitivity extends GameStateActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.room_layout);
        super.onCreate(savedInstanceState);

        Button btnReturn = (Button) findViewById(R.id.buttonRooms);

        Intent i = getIntent();

        // Binding Click event to Button
        btnReturn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                GameState.getGameState().getRoomCollection().getRooms().get(GameState.getGameState().getCurrentRoomId()).upgrade(GameState.getGameState().getAstronaut(), GameState.getGameState().getBaseResources());

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());
                alertDialogBuilder.setTitle("Zoria");
                alertDialogBuilder.setMessage("room upgraded");
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

    }
}