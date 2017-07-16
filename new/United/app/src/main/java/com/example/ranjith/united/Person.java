package com.example.ranjith.united;

/**
 * Created by RANJITH on 16-07-2017.
 */

public class Person {
    private String name;
    private String phone;
    private String gender;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.state=status;
    }
    public String getStatus() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender=gender;}
}
