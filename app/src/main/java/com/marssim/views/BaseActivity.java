package com.marssim.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
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
 * Created by pg on 23/04/16.
 */

public class BaseActivity extends GameStateActivity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.base_resources_layout);
        super.onCreate(savedInstanceState);

    }

}