package com.example.it2_project;

import java.io.Serializable;

/**
 * Created by 고광표 on 2017-11-22.
 */

public class HexagonGraph implements Serializable {

    double QT1;
    double QT2;
    double QT3;
    double QT4;
    double QT5;
    double QT6;

    public HexagonGraph()
    {

    }

    public HexagonGraph(double QT1,double QT2,double QT3,double QT4,double QT5,double QT6)
    {
        this.QT1 = QT1;
        this.QT2 = QT2;
        this.QT3 = QT3;
        this.QT4 = QT4;
        this.QT5 = QT5;
        this.QT6 = QT6;

    }

    public double getQT1() {
        return QT1;
    }

    public double getQT2() {
        return QT2;
    }

    public double getQT3() {
        return QT3;
    }

    public double getQT4() {
        return QT4;
    }

    public double getQT5() {
        return QT5;
    }

    public double getQT6() {
        return QT6;
    }

    public void setQT1(double QT1) {
        this.QT1 = QT1;
    }

    public void setQT2(double QT2) {
        this.QT2 = QT2;
    }

    public void setQT3(double QT3) {
        this.QT3 = QT3;
    }

    public void setQT4(double QT4) {
        this.QT4 = QT4;
    }

    public void setQT5(double QT5) {
        this.QT5 = QT5;
    }

    public void setQT6(double QT6) {
        this.QT6 = QT6;
    }
}
