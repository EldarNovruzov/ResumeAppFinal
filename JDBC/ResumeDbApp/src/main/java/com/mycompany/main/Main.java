/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.main.dao.inter.CountryDaoInter;

/**
 *
 * @author Acer
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        CountryDaoInter country = Context.instanceCountryDao();
        System.out.println(country.getallCountrybyId(2));
    }
}
