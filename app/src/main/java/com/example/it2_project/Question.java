package com.example.it2_project;

import java.io.Serializable;

/**
 * Created by 고광표 on 2017-11-22.
 */

public class Question implements Serializable {

    String Question_title;
    int selection;
    boolean QuestionCheck=false;


    public Question(String Question_title, int selection, boolean QuestionCheck)
    {
        this.Question_title = Question_title;
        this.selection = selection;
        this.QuestionCheck = QuestionCheck;
    }

    public boolean isQuestionCheck() {
        return QuestionCheck;
    }

    public int getSelection() {
        return selection;
    }

    public String getQuestion_title() {
        return Question_title;
    }

    public void setQuestion_title(String question_title) {
        Question_title = question_title;
    }

    public void setQuestionCheck(boolean questionCheck) {
        QuestionCheck = questionCheck;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }
}
