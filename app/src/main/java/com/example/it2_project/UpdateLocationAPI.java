package com.example.it2_project;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 고광표 on 2017-11-26.
 */

public class UpdateLocationAPI {


    public void updateGPS(String id, double lon, double lat, String address, String time) {

        String url1 = "http://192.168.0.6:3000/updateDECTaskDocumentURL/";

        final String openURL = url1 + id + "?lon=" + lon + "&lat=" + lat +"&ad=" + address +"&t=" + time;
        Log.d("siba",openURL);

        try {
            URL url = new URL(openURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.getInputStream();
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL");
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println("URL Connection failed");
            e.printStackTrace();
        }

    }


}
