/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "admin_login")

public class AdminLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadmin_login")
    private Integer idadminLogin;
    @Basic(optional = false)
    @Lob
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public AdminLogin() {
    }

    public AdminLogin(Integer idadminLogin) {
        this.idadminLogin = idadminLogin;
    }

    public AdminLogin(Integer idadminLogin, String email, String password) {
        this.idadminLogin = idadminLogin;
        this.email = email;
        this.password = password;
    }

    public Integer getIdadminLogin() {
        return idadminLogin;
    }

    public void setIdadminLogin(Integer idadminLogin) {
        this.idadminLogin = idadminLogin;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadminLogin != null ? idadminLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminLogin)) {
            return false;
        }
        AdminLogin other = (AdminLogin) object;
        if ((this.idadminLogin == null && other.idadminLogin != null) || (this.idadminLogin != null && !this.idadminLogin.equals(other.idadminLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.AdminLogin[ idadminLogin=" + idadminLogin + " ]";
    }
    
}
