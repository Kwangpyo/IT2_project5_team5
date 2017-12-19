package com.example.it2_project;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 고광표 on 2017-11-26.
 */

public class AddUserAPI {

    public void add(String id, String name, String password,String email_before,String email_after) {

        String url1 = "http://192.168.0.6:3000/addTaskDocumentURL/";
        final String openURL = url1 + id + "?n=" + name + "&s=student" + "&p=" + password + "&e_b=" + email_before + "&e_a=" + email_after;


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
