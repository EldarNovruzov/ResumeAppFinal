/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main.dao.inter;

import com.mycompany.entity.Country;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface CountryDaoInter {
     public List<Country> getallCountry();
     public List<Country> getallCountrybyId(int id);
}
