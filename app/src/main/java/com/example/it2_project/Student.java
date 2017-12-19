package com.example.it2_project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 고광표 on 2017-11-02.
 */

public class Student implements Serializable {

    String id;
    String password;
    String name;
    double violence_prob;
    String email;
    String phone;
    double SOS_lon;
    double SOS_lat;
    double DEC_lon;
    double DEC_lat;

    Question[] survey= new Question[33];;
    //ArrayList<Question> survey = new ArrayList<>();
   HexagonGraph hexagonGraph = new HexagonGraph();


    public Student(String id, String password, String name) {
        this.id=id;
        this.password=password;
        this.name = name;
    }

    public Student(String id, String password, String name, double violence_prob, String email, String phone)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.violence_prob=violence_prob;
        this.email=email;
        this.phone=phone;
    }

    public Student(String id, String password, String name, double violence_prob, String email, String phone, Question[] surv)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.violence_prob=violence_prob;
        this.email=email;
        this.phone=phone;
        this.survey = surv;
    }

    public Student(String id, String password, String name, double violence_prob, String email, String phone, Question[] surv,double SOS_lon,double SOS_lat,double DEC_lon,double DEC_lat)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.violence_prob=violence_prob;
        this.email=email;
        this.phone=phone;
        this.survey = surv;
        this.SOS_lon=SOS_lon;
        this.SOS_lat=SOS_lat;
        this.DEC_lon=DEC_lon;
        this.DEC_lat=DEC_lat;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setViolence_prob(String violence) {
        this.violence_prob = violence_prob;
    }

    public double getViolence_prob() {
        return violence_prob;
    }

    public Question[] getSurvey() {
        return survey;
    }

    public void setSurvey(Question[] survey) {
        this.survey = survey;
    }

    public double getSOS_lon(){return SOS_lon;}
    public double getSOS_lat(){return SOS_lat;}
    public double getDEC_lon(){return DEC_lon;}
    public double getDEC_lat(){return DEC_lon;}

    public void setSOS_lon(double SOS_lon)
    {
        this.SOS_lon=SOS_lon;
    }

    public void setSOS_lat(double SOS_lat)
    {
        this.SOS_lat=SOS_lat;
    }

    public void setDEC_lon(double DEC_lon)
    {
        this.DEC_lon=DEC_lon;
    }

    public void setDEC_lat(double DEC_lat)
    {
        this.DEC_lat=DEC_lat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HexagonGraph getHexagonGraph() {
        return hexagonGraph;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHexagonGraph(HexagonGraph hexagonGraph) {
        this.hexagonGraph = hexagonGraph;
    }

    public void setViolence_prob(double violence_prob) {
        this.violence_prob = violence_prob;
    }

}
