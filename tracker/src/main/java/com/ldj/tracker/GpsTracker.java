package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class GpsTracker {

    private OnGpsChangedListener listener;

    public void startLocation(OnGpsChangedListener listener) {
        this.listener = listener;
    }

    public void stopLocation() {

    }

    interface OnGpsChangedListener {
        /**
         * Gps changed listener
         * @param entity
         */
        void onGpsChanged(GpsEntity entity);
    }

    public static class GpsEntity {
        public long timestamp;
        public double lat;
        public double lng;
    }
}
