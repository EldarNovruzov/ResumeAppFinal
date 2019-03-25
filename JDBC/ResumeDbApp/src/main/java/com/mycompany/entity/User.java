/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Acer
 */
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private Date birthDate;
    private String address;
    private String profileDesc;
    private Country birthplace;
    private Country nationality;
    private List<UserSkill> userskil;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String email, String phone, Date birthDate,String profileDesc, Country birthplace, Country nationality,String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.profileDesc=profileDesc;
        this.address=address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<UserSkill> getUserskil() {
        return userskil;
    }

    public void setUserskil(List<UserSkill> userskil) {
        this.userskil = userskil;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", birthDate=" + birthDate + ", address=" + address + ", profileDesc=" + profileDesc + ", birthplace=" + birthplace + ", nationality=" + nationality + ", userskil=" + userskil + '}';
    }

    
    

}
