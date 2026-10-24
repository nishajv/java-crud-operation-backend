package com.poddar.CrudOperation.mapper;

public class UserRequest {
    String name;
    String mobileNo;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}














/*
Name = string
  Mobile No. = long
  Email = string
  Password = string
  Status : active /not = Boolean
 */