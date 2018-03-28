package com.ldj.tracker;

import android.content.Context;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

class GpsTracker {
    private Context context;
    private OnGpsChangedListener listener;
    private boolean mUseGPS;
    private boolean mUseNetwork;
    private boolean mUsePassive;
    private int type;

    private GpsTracker() {
    }

    private GpsTracker(Context context) {
        this.context = context;
    }

    void startLocation() {

    }

    void stopLocation() {

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

    public static class Builder {
        private final Context context;
        private OnGpsChangedListener listener;
        private boolean mUseGPS;
        private boolean mUseNetwork;
        private boolean mUsePassive;
        private int type;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setOnGpsChangedListener(OnGpsChangedListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setUseGPS(boolean b) {
            this.mUseGPS = b;
            return this;
        }

        public Builder setUseNetwork(boolean b) {
            this.mUseNetwork = b;
            return this;
        }

        public Builder setUsePassive(boolean usePassive) {
            this.mUsePassive = usePassive;
            return this;
        }

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public GpsTracker build() {
            return new GpsTracker(context);
        }
    }
}
