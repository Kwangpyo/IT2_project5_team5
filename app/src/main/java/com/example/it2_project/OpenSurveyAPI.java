package com.example.it2_project;

import android.os.AsyncTask;

/**
 * Created by GyuRie on 2017-12-03.
 */

public class OpenSurveyAPI extends AsyncTask<Student, Void, Integer> {


    @Override
    protected Integer doInBackground(Student... students) {

        Student user=students[0];

        UpdateSurveyAPI updatesurvey=new UpdateSurveyAPI();
        updatesurvey.updateSurvey(user);
        return 1;
    }
}
