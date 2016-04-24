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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marssim.Astronaut;
import com.marssim.GameState;
import com.marssim.Property;
import com.marssim.R;
import com.marssim.rooms.AbstractRoom;


/**
 * Created by pg on 23/04/16.
 */



public class RoomAcitivity extends GameStateActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.room_layout);
        super.onCreate(savedInstanceState);

        ImageView img = (ImageView) findViewById(R.id.imageViewFeature);

        int imgres;

        AbstractRoom currentRoom2 = GameState.getGameState().getRoomCollection().getRooms().get(GameState.getGameState().getCurrentRoomId());

        img.setImageResource(currentRoom2.getImage());

        Button btnReturn = (Button) findViewById(R.id.buttonRooms);

        Intent i = getIntent();



        // Binding Click event to Button
        btnReturn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                AbstractRoom currentRoom = GameState.getGameState().getRoomCollection().getRooms().get(GameState.getGameState().getCurrentRoomId());
                currentRoom.upgrade(GameState.getGameState().getAstronaut(), GameState.getGameState().getBaseResources());
                Toast.makeText(getBaseContext(), "Room upgrated", Toast.LENGTH_SHORT).show();
            }
        });


    }
}