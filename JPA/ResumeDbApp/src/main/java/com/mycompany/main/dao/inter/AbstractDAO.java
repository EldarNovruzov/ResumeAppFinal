/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
    private static EntityManagerFactory emf=null;
    
    public EntityManager em(){
        if (emf==null) {
            emf = Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }
    
    public void closeEmf(){
        emf.close();
    }
}
