package com.example.final_assignments.entity;

public class Building {
    private int uid;
    private double Waterprice;
    private double Electricityprice;
    private String buildingtype;
    private String address;
    private String day;
    private double rent;
    private double beforewaternumber;
    private double beforeElectricitynumber;
    private String buildingnum;


    public String getBuildingnum() {
        return buildingnum;
    }

    public void setBuildingnum(String buildingnum) {
        this.buildingnum = buildingnum;
    }

    public double Total_cost(double currentwaternumber, double currentElectricitynumber, String newday){
        double cost;
        cost=rent+(currentwaternumber-beforewaternumber)*Waterprice+(currentElectricitynumber-beforeElectricitynumber)*Electricityprice;
        beforewaternumber=currentwaternumber;
        beforeElectricitynumber=currentElectricitynumber;
        day="";
        day=newday;
        return cost;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getWaterprice() {
        return Waterprice;
    }

    public void setWaterprice(double waterprice) {
        Waterprice = waterprice;
    }

    public double getElectricityprice() {
        return Electricityprice;
    }

    public void setElectricityprice(double electricityprice) {
        Electricityprice = electricityprice;
    }

    public String getBuildingtype() {
        return buildingtype;
    }

    public void setBuildingtype(String buildingtype) {
        this.buildingtype = buildingtype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getBeforewaternumber() {
        return beforewaternumber;
    }

    public void setBeforewaternumber(double beforewaternumber) {
        this.beforewaternumber = beforewaternumber;
    }

    public double getBeforeElectricitynumber() {
        return beforeElectricitynumber;
    }

    public void setBeforeElectricitynumber(double beforeElectricitynumber) {
        this.beforeElectricitynumber = beforeElectricitynumber;
    }

    @Override
    public String toString() {
        return "Building{" +
                "uid=" + uid +
                ", Waterprice=" + Waterprice +
                ", Electricityprice=" + Electricityprice +
                ", buildingtype='" + buildingtype + '\'' +
                ", address='" + address + '\'' +
                ", day='" + day + '\'' +
                ", rent=" + rent +
                ", beforewaternumber=" + beforewaternumber +
                ", beforeElectricitynumber=" + beforeElectricitynumber +
                ", buildingnum='" + buildingnum + '\'' +
                '}';
    }
}
