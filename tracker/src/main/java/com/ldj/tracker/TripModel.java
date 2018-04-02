package com.ldj.tracker;

import java.util.ArrayList;

/**
 *
 * @author lidajun
 * @date 2018/4/2
 */

public class TripModel {
    public long createTime;
    public float maxSpeed;
    public float averageSpeed;
    public double mileage;
    public ArrayList<GpsTracker.GpsEntity> acce;
    public ArrayList<GpsTracker.GpsEntity> turn;
    public ArrayList<GpsTracker.GpsEntity> brake;
}
