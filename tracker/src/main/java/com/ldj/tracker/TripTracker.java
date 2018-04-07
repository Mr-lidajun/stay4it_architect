package com.ldj.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/**
 *
 * @author lidajun
 * @date 2018/2/25
 */

public class TripTracker implements GpsTracker.OnGpsChangedListener,
        SensorTracker.OnSensorChangedListener {

    private final TripSettings settings;
    private GpsTracker mGpsTracker;
    private SensorTracker mSensorTracker;
    private IProcessor processor;
    private Handler handler;

    public TripTracker(TripSettings settings) {
        this.settings = settings;
    }

    public void startTracker() {

        Context context = null;
        mGpsTracker = new GpsTracker.Builder(context)
                .setOnGpsChangedListener(this)
                .setUseGPS(true)
                .setUseNetwork(true)
                .setUsePassive(true)
                .build();
        mGpsTracker.startLocation();

        mSensorTracker = new SensorTracker.Builder(context)
                .setOnSensorChangedListener(this)
                .setSamplingPeriodUs(settings.samplingPeriodUs)
                .setSensorTypes(settings.sensorTypes)
                .build();
        mSensorTracker.startSensor();
        HandlerThread thread = new HandlerThread("processor");
        handler = new Handler(thread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    processor.onGpsChanged((GpsTracker.GpsEntity) msg.obj);
                } else if (msg.what == 1) {
                    processor.onSensorChanged((SensorTracker.SensorEntity) msg.obj);
                }
            }
        };
    }

    public void stopTracker() {
        mGpsTracker.stopLocation();
        mSensorTracker.stopSensor();
        processor.close();
    }

    @Override
    public void onGpsChanged(GpsTracker.GpsEntity gps) {
        Message message = Message.obtain();
        message.what = 0;
        message.obj = gps;
        handler.sendMessage(message);
    }

    @Override
    public void onSensorChanged(SensorTracker.SensorEntity sensor) {
        Message message = Message.obtain();
        message.what = 1;
        message.obj = sensor;
        handler.sendMessage(message);
    }

    public void setProcessor(IProcessor processor) {
        this.processor = processor;
    }
}
