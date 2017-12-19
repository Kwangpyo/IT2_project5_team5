package com.example.it2_project;

import android.os.AsyncTask;

/**
 * Created by GyuRie on 2017-12-04.
 */

public class OpenHexagonAPI extends AsyncTask<Student, Void, Integer> {


    @Override
    protected Integer doInBackground(Student... students) {

        Student student = students[0];

        UpdateHexagonAPI updatehexagon = new UpdateHexagonAPI();
        updatehexagon.updateHexagon(student);
        return 1;
    }
}