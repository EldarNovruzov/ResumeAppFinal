/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;

import com.mycompany.entity.Skill;
import com.mycompany.main.dao.inter.AbstractDAO;
import com.mycompany.main.dao.inter.SkillDaoInter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Acer
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {


    @Override
    public List<Skill> getallSkills() {
        EntityManager em= em();
        Query q= em.createQuery("select s from Skill s ");

        return q.getResultList();
    }

    @Override
    public List<Skill> getallSkillsbyId(int id) {
        EntityManager em= em();
        Query q = em.createQuery("select s from Skill s where s.id=:id");

        return q.getResultList();
    }

    @Override

    public boolean updateSkill(Skill u) {

        EntityManager em= em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();

        return true;
    }

    public boolean insertSkill(Skill skl) {
        EntityManager em= em();
        em.getTransaction().begin();
        em.persist(skl);
        em.getTransaction().commit();

        return true;

    }

    @Override

    public boolean removeSkill(int id) {
        EntityManager em=em();

        Skill skill = em.find(Skill.class, id);
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
        return true;
    }

    @Override

    public List<Skill> getByName(String sname) {

       EntityManager em=em();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Skill> cbq = cb.createQuery(Skill.class);
        Root<Skill> from = cbq.from(Skill.class);

        CriteriaQuery<Skill> cqn = cbq.where(cb.equal(from.get("name"), sname));

        Query query= em.createQuery(cqn);

        return query.getResultList();

    }

}
