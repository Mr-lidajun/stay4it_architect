package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripManager {

    private TripTracker tracker;
    private OnLocationChangedListener listener;

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

    public void setLocationChangedListener(OnLocationChangedListener listener) {
        this.listener = listener;
        if (tracker != null) {
            tracker.setLocationChangedListener(listener);
        }
    }

    public interface OnLocationChangedListener{
        void onLocationChanged(GpsTracker.GpsEntity location);
    }
}
