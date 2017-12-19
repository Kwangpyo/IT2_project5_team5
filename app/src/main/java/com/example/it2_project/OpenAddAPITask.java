package com.example.it2_project;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by 고광표 on 2017-11-26.
 */

public class OpenAddAPITask extends AsyncTask<String, Void, Integer> {
    @Override
    protected Integer doInBackground(String... params) {

        String id = params[0];
        String name = params[1];
        String password = params[2];
        String email_before = params[3];
        String email_after = params[4];

        AddUserAPI add = new AddUserAPI();
        add.add(id,name,password, email_before,email_after);

        return 1;
    }
}
