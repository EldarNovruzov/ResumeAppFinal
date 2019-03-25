/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

/**
 *
 * @author Acer
 */
public class UserSkill {
    private Integer id;
    private User u;
    private Skill skill;
    private Integer power;

    public UserSkill() {
    }

    public UserSkill(Integer id, User u, Skill skill, Integer power) {
        this.id = id;
        this.u = u;
        this.skill = skill;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", u=" + u + ", skill=" + skill + ", power=" + power + '}';
    }
    
    
}
