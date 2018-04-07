package com.ldj.tracker;

import java.util.ArrayList;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class Processor implements IProcessor {
    private ArrayList<OnTripUpdateListener> listeners = new ArrayList<>();

    @Override
    public void onGpsChanged(GpsTracker.GpsEntity gps) {

    }

    @Override
    public void onSensorChanged(SensorTracker.SensorEntity sensor) {

    }

    @Override
    public void close() {
        // flush
    }

    @Override
    public void registerTripUpdateListener(OnTripUpdateListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterTripUpdateListener(OnTripUpdateListener listener) {
        listeners.add(listener);
    }
}
