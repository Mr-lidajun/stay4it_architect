package com.ldj.tracker;

import java.util.ArrayList;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripManager {

    private TripTracker tracker;
    private ArrayList<OnTripUpdateListener> listeners;
    private static TripManager instance = new TripManager();

    public static TripManager getInstance() {
        return instance;
    }

    public void startTrip() {
        TripSettings settings = new TripSettings();
        tracker = new TripTracker(settings);
        tracker.setLocationChangedListener(listener);
        tracker.startTracker();
    }

    public void stopTrip() {
        tracker.stopTracker();
        tracker = null;
    }

    public void registerTripUpdateListener(OnTripUpdateListener listener) {
        listeners.add(listener);
    }

    public void unregisterTripUpdateListener(OnTripUpdateListener listener) {
        listeners.remove(listener);
    }

    public interface OnTripUpdateListener {
        void onTripUpdated(TripModel trip);
    }
}
