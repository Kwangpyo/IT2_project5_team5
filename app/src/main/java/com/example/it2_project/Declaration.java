package com.example.it2_project;

import java.util.Date;

/**
 * Created by 고광표 on 2017-11-27.
 */

public class Declaration {

    String id;
    double lon;
    double lat;

    String address;
    String time;

    public Declaration(String id, double lon, double lat, String address, String time)
    {
        this.id=id;
        this.lon=lon;
        this.lat=lat;
        this.address=address;
        this.time=time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
