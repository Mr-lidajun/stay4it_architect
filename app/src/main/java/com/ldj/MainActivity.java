package com.ldj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ldj.tracker.TripManager;
import com.ldj.tracker.TripModel;

public class MainActivity extends AppCompatActivity implements TripManager.OnTripUpdateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        TripManager.getInstance().registerTripUpdateListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TripManager.getInstance().unregisterTripUpdateListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTripUpdated(TripModel trip) {

    }
}
