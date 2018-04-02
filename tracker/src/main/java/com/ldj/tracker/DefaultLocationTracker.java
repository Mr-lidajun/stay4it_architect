package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/3/27
 */

public class DefaultLocationTracker extends LocationTracker{
    public DefaultLocationTracker(boolean mUseGPS, boolean mUseNetwork, boolean mUsePassive) {
        super(mUseGPS, mUseNetwork, mUsePassive);
    }

    @Override
    public void startLocation() {

    }

    @Override
    public void stopLocation() {

    }
}
