package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/3/29
 */

public abstract class LocationTracker {
    private boolean mUseGPS;
    private boolean mUseNetwork;
    private boolean mUsePassive;

    public LocationTracker(boolean mUseGPS, boolean mUseNetwork, boolean mUsePassive) {
        this.mUseGPS = mUseGPS;
        this.mUseNetwork = mUseNetwork;
        this.mUsePassive = mUsePassive;
    }

    public abstract void startLocation();

    public abstract void stopLocation();

    public interface LocationChangedListener {
        void onLocationChanged(GpsTracker.GpsEntity entity);
    }
}
