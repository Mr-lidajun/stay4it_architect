package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripTracker implements GpsTracker.OnGpsChangedListener,
        SensorTracker.OnSensorChangedListener {

    private GpsTracker mGpsTracker;
    private SensorTracker mSensorTracker;
    private TripWriter mTripWriter;

    public void startTracker() {
        mGpsTracker = new GpsTracker();
        mGpsTracker.startLocation(this);
        mSensorTracker = new SensorTracker();
        mSensorTracker.startSensor(this);
        mTripWriter = new TripWriter();
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
