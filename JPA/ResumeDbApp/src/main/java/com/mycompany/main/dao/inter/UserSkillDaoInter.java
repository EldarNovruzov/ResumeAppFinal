/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main.dao.inter;

import com.mycompany.entity.UserSkill;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface UserSkillDaoInter {

    public List<UserSkill> getAllSkillByUserId(int id);

    public boolean insertUserSkill(UserSkill u);

    public boolean updateUserSkill(UserSkill u);

    public boolean removeUserSkill(int id);

}
