package com.example.it2_project;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by GyuRie on 2017-12-04.
 */

public class UpdateHexagonAPI {
    public void updateHexagon(Student student) {


        String id = student.getId();
        double h1 = student.getHexagonGraph().getQT1();
        double h2 = student.getHexagonGraph().getQT2();
        double h3 = student.getHexagonGraph().getQT3();
        double h4 = student.getHexagonGraph().getQT4();
        double h5 = student.getHexagonGraph().getQT5();
        double h6 = student.getHexagonGraph().getQT6();

        String url1 = "http://192.168.0.6:3000/updateHexagonTaskDocumentURL/";
        final String openURL = url1 + id + "?h1=" + h1 + "&h2=" + h2 + "&h3=" + h3 + "&h4=" + h4 + "&h5=" + h5 + "&h6=" + h6;

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
