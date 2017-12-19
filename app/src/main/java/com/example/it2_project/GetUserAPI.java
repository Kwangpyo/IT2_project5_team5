package com.example.it2_project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 고광표 on 2017-11-09.
 */

public class GetUserAPI {
    final static String openURL = "http://192.168.0.6:3000/getAllTaskDocuments";
    ArrayList<Student> persons = new ArrayList<>();

    public ArrayList<Student> getJson() {



        try {

            URL url = new URL(openURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            JSONObject json = new JSONObject(getStringFromInputStream(in));

            // w = json.toString();
            parseJSON(json);


        } catch (MalformedURLException e) {

            System.err.println("Malformed URL");

            e.printStackTrace();
            return null;

        } catch (JSONException e) {

            System.err.println("JSON parsing error");

            e.printStackTrace();

            return null;

        } catch (IOException e) {

            System.err.println("URL Connection failed");

            e.printStackTrace();

            return null;

        }

        return persons;
    }



    private void parseJSON(JSONObject json) throws JSONException {

        JSONArray datas = json.getJSONArray("tasks");

        int size = datas.length();
        //  String id1;
        //   id1 = datas.getJSONObject(1).getString("_id");

        for(int i=0;i<size;i++)
        {
//            Person st = new Person();
  //          st.setId(datas.getJSONObject(i).getString("title"));
    //        st.setPassword(datas.getJSONObject(i).getString("password"));
/*
            if(datas.getJSONObject(i).getString("status").equals("teacher"))
            {
                Teacher tc = new Teacher(datas.getJSONObject(i).getString("title"),datas.getJSONObject(i).getString("password"));
                persons.add(tc);

            } */
            if(datas.getJSONObject(i).getString("status").equals("student"))
            {
                Student st = new Student(datas.getJSONObject(i).getString("title"),datas.getJSONObject(i).getString("password"),datas.getJSONObject(i).getString("content"));

                persons.add(st);
            }

            //persons.add(st);
        }


    }



    private static String getStringFromInputStream(InputStream is) {



        BufferedReader br = null;

        StringBuilder sb = new StringBuilder();



        String line;

        try {



            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {

                sb.append(line);

            }



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (br != null) {

                try {

                    br.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }



        return sb.toString();



    }
}
