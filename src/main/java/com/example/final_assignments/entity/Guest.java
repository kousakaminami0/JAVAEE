package com.example.final_assignments.entity;

public class Guest {
    private String id;
    private String name;
    private String phone;
    private String sex;
    private String address;
    private String day;
    private String buildingnum;

    public String getBuildingnum() {
        return buildingnum;
    }

    public void setBuildingnum(String buildingnum) {
        this.buildingnum = buildingnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    @Override
    public String toString() {
        return "Guest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", day='" + day + '\'' +
                ", buildingnum='" + buildingnum + '\'' +
                '}';
    }
}
