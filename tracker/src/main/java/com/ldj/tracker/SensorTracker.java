package com.ldj.tracker;

import android.content.Context;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

class SensorTracker {
    private Context context;
    private OnSensorChangedListener listener;
    private int samplingPeriodUs;
    private int[] types;

    private SensorTracker() {
    }

    private SensorTracker(Context context) {
        this.context = context;
    }

    void startSensor() {

    }

    void stopSensor() {

    }

    interface OnSensorChangedListener {
        /**
         * sensor changed listener
         * @param entity
         */
        void onSensorChanged(SensorEntity entity);
    }

    public static class SensorEntity {
        public long timestamp;
        public float[] values;
    }

    public static class Builder {
        private final Context context;
        private float gravity;
        private float threshold;
        private int samplingPeriodUs;
        private OnSensorChangedListener listener;
        private int[] types;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setOnSensorChangedListener(OnSensorChangedListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setSamplingPeriodUs(int periodUs) {
            this.samplingPeriodUs = periodUs;
            return this;
        }

        public Builder setSensorTypes(int[] types) {
            this.types = types;
            return this;
        }

        public SensorTracker build() {
            return new SensorTracker(context);
        }
    }
}
