package com.example.it2_project;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by 고광표 on 2017-11-09.
 */

public class OpenGetAPITask extends AsyncTask<Integer, Void, ArrayList<Student>> {


    @Override
    protected ArrayList<Student> doInBackground(Integer... integers) {

        GetUserAPI client = new GetUserAPI();

        ArrayList<Student> w = client.getJson();

        return w;
    }
}