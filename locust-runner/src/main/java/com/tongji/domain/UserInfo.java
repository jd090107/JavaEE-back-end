package com.tongji.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class UserInfo {

    private String account;
    private String company;
    private String company_size;
    private String job;
    private String password;
    private String username;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account1) {
        this.account = account1;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company1) {
        this.company = company1;
    }

    public String getCompany_size() {
        return company_size;
    }

    public void setCompany_size(String companySize) {
        this.company_size = companySize;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job1) {
        this.job = job1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password1) {
        this.password = password1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username1) {
        this.username = username1;
    }

    @Override
    @JsonIgnore
    public String toString() {
        return "UserInfo{" +
                "account='" + account + '\'' +
                ", company='" + company + '\'' +
                ", company_size='" + company_size + '\'' +
                ", job='" + job + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}