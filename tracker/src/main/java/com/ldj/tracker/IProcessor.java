package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/4/7
 */

public interface IProcessor {
    void onGpsChanged(GpsTracker.GpsEntity gps);

    void onSensorChanged(SensorTracker.SensorEntity sensor);

    void close();

    void registerTripUpdateListener(OnTripUpdateListener listener);

    void unregisterTripUpdateListener(OnTripUpdateListener listener);
}
