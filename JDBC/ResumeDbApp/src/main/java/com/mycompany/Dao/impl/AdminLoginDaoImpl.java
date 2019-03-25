package com.mycompany.Dao.impl;

import com.mycompany.entity.AdminLogin;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.main.dao.inter.AbstractDAO;
import com.mycompany.main.dao.inter.AdminLoginDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminLoginDaoImpl extends AbstractDAO implements AdminLoginDaoInter {
    @Override
    public List<AdminLogin> getAll() {
        List<AdminLogin> ad = new ArrayList<>();
        try (Connection r = connect()) {

            Statement stmt=r.createStatement();

            stmt.execute("SELECT * FROM admin_login;");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                AdminLogin u = getAdminLogin(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

    private AdminLogin getAdminLogin(ResultSet rs) throws Exception {
        int id = rs.getInt("idadmin_login");
        String loginemail = rs.getString("email");
        String password = rs.getString("password");

       AdminLogin login= new AdminLogin(id,loginemail,password);

       return (login);
    }

}
