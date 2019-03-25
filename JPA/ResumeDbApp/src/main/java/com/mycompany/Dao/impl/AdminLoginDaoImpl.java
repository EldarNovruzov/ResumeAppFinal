package com.mycompany.Dao.impl;

import com.mycompany.entity.AdminLogin;
import com.mycompany.main.dao.inter.AbstractDAO;
import com.mycompany.main.dao.inter.AdminLoginDaoInter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AdminLoginDaoImpl extends AbstractDAO implements AdminLoginDaoInter {
    @Override
    public List<AdminLogin> getAll() {
        EntityManager em = em();
        Query qr = em.createQuery("select al from AdminLogin  al");

        return qr.getResultList();
    }

}
