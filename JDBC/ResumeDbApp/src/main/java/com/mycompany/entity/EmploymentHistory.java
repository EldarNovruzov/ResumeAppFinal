/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class EmploymentHistory {

    private Integer id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDescription;
    private User userid;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDescription, User userid) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" + "id=" + id + ", header=" + header + ", beginDate=" + beginDate + ", endDate=" + endDate + ", jobDescription=" + jobDescription + ", userid=" + userid + '}';
    }

}
