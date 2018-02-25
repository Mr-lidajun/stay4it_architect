package com.ldj.tracker;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class SensorTracker {

    private OnSensorChangedListener listener;

    public void startSensor(OnSensorChangedListener listener) {
        this.listener = listener;
    }

    public void stopSensor() {

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
}
