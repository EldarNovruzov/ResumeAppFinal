/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;

import com.mycompany.entity.Country;
import com.mycompany.main.dao.inter.AbstractDAO;
import static com.mycompany.main.dao.inter.AbstractDAO.connect;
import com.mycompany.main.dao.inter.CountryDaoInter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {


    @Override
    public List<Country> getallCountry() {
        EntityManager em = em();
        Query q = em.createQuery("select c from Country c");
        return q.getResultList();
    }

    @Override
    public List<Country> getallCountrybyId(int id) {
        EntityManager em = em();
        Query q = em.createQuery("select c from Country c where c.id=:cid");
        q.setParameter("cid",id);
        return q.getResultList();
    }

}
