package com.example.it2_project;

import android.content.Intent;
import android.os.AsyncTask;

/**
 * Created by 고광표 on 2017-11-27.
 */

public class OpenLocationAPI extends AsyncTask<Declaration, Void, Integer> {


    @Override
    protected Integer doInBackground(Declaration... declarations) {

        Declaration info = declarations[0];
        String id = info.getId();
        double lon = info.getLon();
        double lat = info.getLat();
        String address=info.getAddress();
        String time=info.getTime();

        UpdateLocationAPI update = new UpdateLocationAPI();
        update.updateGPS(id,lon,lat, address, time);

        return 1;
    }
}
