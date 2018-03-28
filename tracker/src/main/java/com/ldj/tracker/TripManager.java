package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripManager {

    private TripTracker mTracker;

    public void startTrip() {
        TripSettings settings = new TripSettings();
        mTracker = new TripTracker(settings);
        mTracker.startTracker();
    }

    public void stopTrip() {
        mTracker.stopTracker();
    }
}
