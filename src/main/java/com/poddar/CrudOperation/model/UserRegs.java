package com.poddar.CrudOperation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity

public class UserRegs {
    @Id
    long id;
    String name;
    String mobileNo;
    String email;
    String password;
    String createDate;
    String modifiedDate;
    String deleteDate;
    boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
@Override


    public String toString() {
        return "UserRegs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", status=" + status +
                '}';
    }
}












/*
PostUser
table = User Registration
  ID = long
  Name = string
  Mobile No. = long
  Email = string
  Password = string
  Created date = string
  Modified date = string
  Delete date = string
  Status : active /not = Boolean
 */