/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;


import com.mycompany.entity.UserSkill;
import com.mycompany.main.dao.inter.AbstractDAO;
import com.mycompany.main.dao.inter.UserSkillDaoInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;




public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {



    @Override

    public List<UserSkill> getAllSkillByUserId(int id) {
        EntityManager em = em();
        Query createQuery = em.createQuery("select us from UserSkill us where us.user.id=:userid");
        createQuery.setParameter("userid", id);
        return createQuery.getResultList();
    }



    public boolean insertUserSkill(UserSkill u) {

        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        return true;
    }



    public boolean updateUserSkill(UserSkill u) {
       EntityManager em= em();
       em.getTransaction().begin();
       em.merge(u);
       em.getTransaction().commit();
        return true;
    }



    @Override

    public boolean removeUserSkill(int id) {
        EntityManager em=em();
        UserSkill us= em.find(UserSkill.class,id);

        em.getTransaction().begin();
        em.remove(us);
        em.getTransaction().commit();

        return true;
    }

}