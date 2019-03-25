/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.main.dao.inter.AbstractDAO;
import static com.mycompany.main.dao.inter.AbstractDAO.connect;
import com.mycompany.main.dao.inter.EmploymentHistoryDaoInter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {


    @Override
    public List<EmploymentHistory> getallEmploymentHistorybyuserId(int userId) {
        EntityManager em= em();
        Query query = em.createQuery("select eh from EmploymentHistory eh where eh.user.id=:usid ");
        query.setParameter("usid",userId);
        return query.getResultList();
    }

}
