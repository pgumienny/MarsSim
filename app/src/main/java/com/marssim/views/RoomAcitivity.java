package com.marssim.views;

import android.app.Activity;
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
    }
}