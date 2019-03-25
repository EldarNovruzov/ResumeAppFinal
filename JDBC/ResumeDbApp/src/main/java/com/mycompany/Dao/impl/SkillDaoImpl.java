/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;

import com.mycompany.entity.Skill;
import com.mycompany.main.dao.inter.AbstractDAO;
import static com.mycompany.main.dao.inter.AbstractDAO.connect;
import com.mycompany.main.dao.inter.SkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    private Skill getall(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return (new Skill(id, name));
    }

    @Override
    public List<Skill> getallSkills() {
        List<Skill> ad = new ArrayList<>();
        try (Connection r = connect()) {

            Statement stmt = r.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill u = getall(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

    @Override
    public List<Skill> getallSkillsbyId(int id) {
        List<Skill> ad = new ArrayList<>();
        try (Connection r = connect()) {

            Statement stmt = r.createStatement();
            stmt.execute("select * from skill where id=" + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill u = getall(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

    @Override

    public boolean updateSkill(Skill u) {

        Connection conn;

        boolean b = true;

        try {

            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("UPDATE skill SET name=? WHERE id= ?");

            stmt.setString(1, u.getName());

            stmt.setInt(2, u.getId());

            b = stmt.execute();

        } catch (Exception ex) {

            System.err.println(ex);

            b = false;

        }

        return b;

    }

    public boolean insertSkill(Skill skl) {

        Connection conn;

        boolean b = true;

        try {

            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("insert skill (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, skl.getName());

            b = stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    skl.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (Exception ex) {

            System.err.println(ex);

            b = false;

        }

        return b;

    }

    @Override

    public boolean removeSkill(int id) {

        Connection conn;

        try {

            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM skill WHERE id=?;");

            stmt.setInt(1, id);

            return stmt.execute();

        } catch (Exception ex) {

            System.err.println(ex);

            return false;

        }

    }

    @Override

    public List<Skill> getByName(String sname) {

        List<Skill> list = new ArrayList<>();

        Connection conn;

        try {

            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM skill WHERE name LIKE ?;");

            stmt.setString(1, sname);

            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                int id = rs.getInt("Id");

                String name = rs.getString("name");

                list.add(new Skill(id, name));

            }

        } catch (Exception ex) {

            System.err.println("Houston, we have a problem");

        }

        return list;

    }

}
