/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main.dao.inter;

import com.mycompany.entity.Skill;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface SkillDaoInter {

    public List<Skill> getallSkills();

    public List<Skill> getallSkillsbyId(int id);

    boolean updateSkill(Skill u);

    boolean removeSkill(int id);

    public List<Skill> getByName(String name);

    public boolean insertSkill(Skill skl);
}
