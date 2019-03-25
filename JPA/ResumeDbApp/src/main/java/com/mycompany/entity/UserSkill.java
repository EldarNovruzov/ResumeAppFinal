/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "user_skill")

public class UserSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "power")
    private int power;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private User user;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Skill skill;

    public UserSkill() {
    }

    public UserSkill(Integer id) {
        this.id = id;
    }

    public UserSkill(Integer id, int power) {
        this.id = id;
        this.power = power;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public User getU() {
        return user;
    }

    public void setU(User u) {
        this.user = u;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSkill userSkill = (UserSkill) o;

        if (power != userSkill.power) return false;
        if (id != null ? !id.equals(userSkill.id) : userSkill.id != null) return false;
        if (user != null ? !user.equals(userSkill.user) : userSkill.user != null) return false;
        return skill != null ? skill.equals(userSkill.skill) : userSkill.skill == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + power;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.UserSkill[ id=" + id + " ]";
    }
    
}
