package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripManager {

    private TripTracker mTripTracker;

    public void startTrip() {
        mTripTracker = new TripTracker();
        mTripTracker.startTracker();
    }

    public void stopTrip() {
        mTripTracker.stopTracker();
    }
}
