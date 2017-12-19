package com.example.it2_project;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by GyuRie on 2017-12-03.
 */

public class UpdateSurveyAPI {


    public void updateSurvey(Student student) {

        String url1 = "http://192.168.0.6:3000/updateViolenceTaskDocumentURL/";

        final String openURL = url1 + student.getId() +"?q1="+student.getSurvey()[1].getSelection()+"&q2="+ student.getSurvey()[2].getSelection()+
                "&q3="+ student.getSurvey()[3].getSelection()+ "&q4="+ student.getSurvey()[4].getSelection()+ "&q5="+ student.getSurvey()[5].getSelection()+
                "&q6="+ student.getSurvey()[6].getSelection()+"&q7="+ student.getSurvey()[7].getSelection()+ "&q8="+ student.getSurvey()[8].getSelection()+
                "&q9="+ student.getSurvey()[9].getSelection()+ "&q10="+ student.getSurvey()[10].getSelection()+ "&q11="+student.getSurvey()[11].getSelection()+"&q12="+ student.getSurvey()[12].getSelection()+
                "&q13="+ student.getSurvey()[13].getSelection()+ "&q14="+ student.getSurvey()[14].getSelection()+ "&q15="+ student.getSurvey()[15].getSelection()+
                "&q16="+ student.getSurvey()[16].getSelection()+"&q17="+ student.getSurvey()[17].getSelection()+ "&q18="+ student.getSurvey()[18].getSelection()+
                "&q19="+ student.getSurvey()[19].getSelection()+ "&q20="+ student.getSurvey()[20].getSelection()+"&q21="+student.getSurvey()[21].getSelection()+"&q22="+ student.getSurvey()[22].getSelection()+
                "&q23="+ student.getSurvey()[23].getSelection()+ "&q24="+ student.getSurvey()[24].getSelection()+ "&q25="+ student.getSurvey()[25].getSelection()+
                "&q26="+ student.getSurvey()[26].getSelection()+"&q27="+ student.getSurvey()[27].getSelection()+ "&q28="+ student.getSurvey()[28].getSelection()+
                "&q29="+ student.getSurvey()[29].getSelection()+ "&q30="+ student.getSurvey()[30].getSelection() ;
        Log.d("siba",String.valueOf(student.getSurvey()[1].getSelection()));

        try {///////////////////////////
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
