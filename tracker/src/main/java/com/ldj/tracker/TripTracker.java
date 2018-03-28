package com.ldj.tracker;

import android.content.Context;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripTracker implements GpsTracker.OnGpsChangedListener,
        SensorTracker.OnSensorChangedListener {

    private final TripSettings settings;
    private GpsTracker mGpsTracker;
    private SensorTracker mSensorTracker;
    private TripWriter mTripWriter;

    public TripTracker(TripSettings settings) {
        this.settings = settings;
    }

    public void startTracker() {
        mTripWriter = new TripWriter();

        Context context = null;
        mGpsTracker = new GpsTracker.Builder(context)
                .setOnGpsChangedListener(this)
                .setUseGPS(true)
                .setUseNetwork(true)
                .setUsePassive(true)
                .build();
        mGpsTracker.startLocation();


        mSensorTracker = new SensorTracker.Builder(context)
                .setOnSensorChangedListener(this)
                .setSamplingPeriodUs(settings.samplingPeriodUs)
                .setSensorTypes(settings.sensorTypes)
                .build();
        mSensorTracker.startSensor();

    }

    public void stopTracker() {
        mGpsTracker.stopLocation();
        mSensorTracker.stopSensor();
        mTripWriter.close();
    }

    @Override
    public void onGpsChanged(GpsTracker.GpsEntity entity) {

    }

    @Override
    public void onSensorChanged(SensorTracker.SensorEntity entity) {

    }
}
