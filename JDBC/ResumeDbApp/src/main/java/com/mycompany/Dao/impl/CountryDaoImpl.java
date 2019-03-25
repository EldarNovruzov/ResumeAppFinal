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

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        return (new Country(id, name, nationality));
    }

    @Override
    public List<Country> getallCountry() {
        List<Country> ad = new ArrayList<>();
        try (Connection r = connect()) {

            Statement stmt = r.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country u = getCountry(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

    @Override
    public List<Country> getallCountrybyId(int id) {
        List<Country> ad = new ArrayList<>();
        try (Connection r = connect()) {

            Statement stmt = r.createStatement();
            stmt.execute("select * from country where id="+id);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country u = getCountry(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

}
