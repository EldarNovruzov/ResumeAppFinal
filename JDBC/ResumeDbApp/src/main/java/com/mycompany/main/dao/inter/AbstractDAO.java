/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Acer
 */
public abstract class AbstractDAO {

    public static Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/resume";
        String usern = "root";
        String password = "1999ELDar";
        Connection r = DriverManager.getConnection(url, usern, password);
        return r;
    }
}
