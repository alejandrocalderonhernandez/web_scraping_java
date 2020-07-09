package com.alejandro.info.model;

import com.google.gson.Gson;

public class DataModel {

    private Integer totalCasesCDMX;
    private Integer activeCasesCDMX;
    private Integer newCasesPerDayCDMX;

    private Integer totalCasesEdoMex;
    private Integer activeCasesEdoMex;
    private Integer newCasesPerDayEdoMex;

    private Integer totalCasesMexico;
    private Integer activeCasesMexico;
    private Integer newCasesPerDayMex;


    public  DataModel(){
    }

    public Integer getTotalCasesCDMX() {
        return totalCasesCDMX;
    }

    public void setTotalCasesCDMX(Integer totalCasesCDMX) {
        this.totalCasesCDMX = totalCasesCDMX;
    }

    public Integer getActiveCasesCDMX() {
        return activeCasesCDMX;
    }

    public void setActiveCasesCDMX(Integer activeCasesCDMX) {
        this.activeCasesCDMX = activeCasesCDMX;
    }

    public Integer getNewCasesPerDayCDMX() {
        return newCasesPerDayCDMX;
    }

    public void setNewCasesPerDayCDMX(Integer newCasesPerDayCDMX) {
        this.newCasesPerDayCDMX = newCasesPerDayCDMX;
    }

    public Integer getTotalCasesEdoMex() {
        return totalCasesEdoMex;
    }

    public void setTotalCasesEdoMex(Integer totalCasesEdoMex) {
        this.totalCasesEdoMex = totalCasesEdoMex;
    }

    public Integer getActiveCasesEdoMex() {
        return activeCasesEdoMex;
    }

    public void setActiveCasesEdoMex(Integer activeCasesEdoMex) {
        this.activeCasesEdoMex = activeCasesEdoMex;
    }

    public Integer getNewCasesPerDayEdoMex() {
        return newCasesPerDayEdoMex;
    }

    public void setNewCasesPerDayEdoMex(Integer newCasesPerDayEdoMex) {
        this.newCasesPerDayEdoMex = newCasesPerDayEdoMex;
    }

    public Integer getTotalCasesMexico() {
        return totalCasesMexico;
    }

    public void setTotalCasesMexico(Integer totalCasesMexico) {
        this.totalCasesMexico = totalCasesMexico;
    }

    public Integer getActiveCasesMexico() {
        return activeCasesMexico;
    }

    public void setActiveCasesMexico(Integer activeCasesMexico) {
        this.activeCasesMexico = activeCasesMexico;
    }

    public Integer getNewCasesPerDayMex() {
        return newCasesPerDayMex;
    }

    public void setNewCasesPerDayMex(Integer newCasesPerDayMex) {
        this.newCasesPerDayMex = newCasesPerDayMex;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
