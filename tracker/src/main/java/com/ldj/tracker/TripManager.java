package com.ldj.tracker;

import java.util.ArrayList;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripManager {

    private TripTracker tracker;
    private IProcessor processor;
    private static TripManager instance = new TripManager();

    public static TripManager getInstance() {
        return instance;
    }

    public void startTrip() {
        TripSettings settings = new TripSettings();
        tracker = new TripTracker(settings);
        processor = new Processor();
        tracker.setProcessor(processor);
        tracker.startTracker();
    }

    public void stopTrip() {
        tracker.stopTracker();
        tracker = null;
    }

    public void registerTripUpdateListener(OnTripUpdateListener listener) {
        processor.registerTripUpdateListener(listener);
    }

    public void unregisterTripUpdateListener(OnTripUpdateListener listener) {
        processor.unregisterTripUpdateListener(listener);
    }

}
