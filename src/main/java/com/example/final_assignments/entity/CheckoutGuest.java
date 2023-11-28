package com.example.final_assignments.entity;

public class CheckoutGuest {
    private String id;
    private double currentwaternumber;
    private double currentElectricitynumber;
    private String day;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCurrentwaternumber() {
        return currentwaternumber;
    }

    public void setCurrentwaternumber(double currentwaternumber) {
        this.currentwaternumber = currentwaternumber;
    }

    public double getCurrentElectricitynumber() {
        return currentElectricitynumber;
    }

    public void setCurrentElectricitynumber(double currentElectricitynumber) {
        this.currentElectricitynumber = currentElectricitynumber;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
