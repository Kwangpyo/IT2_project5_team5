package com.example.it2_project;

import com.google.android.gms.games.quest.Quest;

import java.util.ArrayList;

/**
 * Created by GyuRie on 2017-11-23.
 */

public class SurveyList {

    private Question[] survey;


    private SurveyList(){
        survey = new Question[32];
    }
    private static SurveyList ourInstance;

    public static SurveyList getInstance(){
            Question questionInst=new Question(null, 0, false);
        if(ourInstance==null){
            ourInstance=new SurveyList();
            for(int i=0; i<32; i++){

                ourInstance.getSurvey()[i]=questionInst;
            }


        }
        return ourInstance;
    }
    public Question[] getSurvey(){
        return survey;
    }

}
