/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import com.mycompany.main.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.main.dao.inter.UserDaoInter;
import com.mycompany.main.dao.inter.UserSkillDaoInter;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();

        List<User> all = udi.getAll(null, null, null);
        System.out.println(all.get(0).getAddress());


    }
}
