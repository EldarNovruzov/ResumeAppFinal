/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.User;
import com.mycompany.main.dao.inter.AbstractDAO;
import com.mycompany.main.dao.inter.UserDaoInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Acer
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityIdbyRequest) {

        EntityManager em = em();
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nationalityIdbyRequest != null) {
            jpql += " and u.nationality.id=:nid";
        }

        Query q = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityIdbyRequest != null) {
            q.setParameter("nid", nationalityIdbyRequest);
        }

        return q.getResultList();
    }

//    @Override//JPQL
//    public User findbyEmailandPassword(String email, String password) {
//        EntityManager em = em();
//        Query q=em.createQuery("select u from User u where u.email=:e and u.password=:p", User.class);
//        q.setParameter("e", email);
//        q.setParameter("p", password);
//        
//        List<User> resultList = q.getResultList();
//        if (resultList.size()==1) {
//            return resultList.get(0);
//        }
//        return null;
//    }
    @Override//CRITERIA BUILDER
    public User findbyEmailandPassword(String email, String password) {
        EntityManager em = em();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> fr = q1.from(User.class);

        CriteriaQuery<User> cq = q1.where(cb.equal(fr.get("email"), email), cb.equal(fr.get("password"), password));

        Query query = em.createQuery(cq);

        List<User> resultList = query.getResultList();
        if (resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

//    @Override//JPQL
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query q=em.createQuery("select u from User u where u.email=:e", User.class);
//        q.setParameter("e", email);
//        
//        List<User> resultList = q.getResultList();
//        if (resultList.size()==1) {
//            return resultList.get(0);
//        }
//        return null;
//    }
//    @Override//WITH CRITERIA BUILDER
//    public User findByEmail(String email) {
//       EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> fr = q1.from(User.class);
//        
//        CriteriaQuery<User> cq = q1.where(cb.equal(fr.get("email"), email));
//        
//        Query query=em.createQuery(cq);
//        
//        List<User> resultList = query.getResultList();
//        if (resultList.size()==1) {
//            return resultList.get(0);
//        }
//        return null;
//    }
    @Override//WITH NAMED QUERY
    public User findByEmail(String email) {
        EntityManager em = em();
        Query query = em.createNamedQuery("User.findByEmail", User.class);

        query.setParameter("email", email);

        List<User> resultList = query.getResultList();
        if (resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }
    
//    @Override//WITH NATIVE QUERY
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNativeQuery("select * from user where email=?",User.class);
//
//        query.setParameter(1, email);
//
//        List<User> resultList = query.getResultList();
//        if (resultList.size() == 1) {
//            return resultList.get(0);
//        }
//        return null;
//    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();

        em.close();
        return true;

    }

    @Override
    public boolean removeUser(int id) {
        EntityManager em = em();

        User u = em.find(User.class, id);

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public User getbyID(int userId) {
        EntityManager em = em();

        User u = em.find(User.class, userId);

        em.close();
        return u;
    }

    @Override
    public boolean addUser(User u) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        em.close();
        return true;

    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

}
