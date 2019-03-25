/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.main.dao.inter.AbstractDAO;
import static com.mycompany.main.dao.inter.AbstractDAO.connect;
import com.mycompany.main.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDesc = rs.getString("profile_description");
        String address = rs.getString("address");
        int birthplaceId = rs.getInt("birthplace_id");
        int natonalityId = rs.getInt("nationality_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthDate = rs.getDate("birthdate");

        Country nn = new Country(natonalityId, null, nationalityStr);
        Country ss = new Country(birthplaceId, birthplaceStr, null);

        return (new User(id, name, surname, email, phone, birthDate, profileDesc,ss, nn,address));
    }

    private User getUserSimple(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDesc = rs.getString("profile_description");
        String address = rs.getString("address");
        int birthplaceId = rs.getInt("birthplace_id");
        int natonalityId = rs.getInt("nationality_id");
        Date birthDate = rs.getDate("birthdate");

        User u=new User(id, name, surname, email, phone, birthDate, profileDesc,null, null,address);
        u.setPassword(rs.getString("password"));
        return u;
    }

    @Override
    public List<User> getAll(String name,String surname,Integer nationalityIdbyRequest) {
        List<User> ad = new ArrayList<>();
        try (Connection r = connect()) {

            String sql="SELECT "
                    + "	u.*, "
                    + "	n.nationality AS nationality, "
                    + "	c.name AS birthplace  "
                    + "FROM "
                    + "	USER u  "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id  "
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where 1=1 ";

            if (name!=null && !name.trim().isEmpty()){
                sql+="and u.name=?";
            }
            if (surname!=null && !surname.trim().isEmpty()){
                sql+="and u.surname=?";
            }
            if (nationalityIdbyRequest!=null){
                sql+="and u.nationality_id=?";
            }

            PreparedStatement stmt = r.prepareStatement(sql);

            int i=1;
            if (name!=null && !name.trim().isEmpty()){
               stmt.setString(i, name);
               i++;
            }
            if (surname!=null && !surname.trim().isEmpty()){
                stmt.setString(i, surname);
                i++;
            }
            if (nationalityIdbyRequest!=null){
                stmt.setInt(i, nationalityIdbyRequest);
            }

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

    @Override
    public User findbyEmailandPassword(String email, String password) {
        User result=null;
       try(Connection c=connect()){
        PreparedStatement stmt=c.prepareStatement("select * from user where email=? and password=? ");
        stmt.setString(1,email);
        stmt.setString(2,password);
        ResultSet rs=stmt.executeQuery();

        while (rs.next()){
            result=getUserSimple(rs);
        }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection r = connect()) {

            PreparedStatement stmt = r.prepareStatement("update user set name=?,surname=?,email=?,phone=?,profile_description=?,address=?,birthdate=?,birthplace_id=?,nationality_id=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setInt(10, u.getId());
            
            
            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean removeUser(int id) {
        try (Connection r = connect()) {

            Statement stmt = r.createStatement();
            return stmt.execute("delete from user where id=" + id);

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
      @Override
    public User findByEmail(String email) {
        User result = null;
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=?");
            stmt.setString(1,email);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result = getUserSimple(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User getbyID(int userId) {
        User ad = null;
        try (Connection r = connect()) {

            Statement stmt = r.createStatement();
            stmt.execute("SELECT "
                    + "	u.*, "
                    + "	n.nationality AS nationality, "
                    + "	c.name AS birthplace  "
                    + "FROM "
                    + "	USER u  "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id  "
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                ad = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }
    
    private static BCrypt.Hasher crypt=BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        try (Connection r = connect()) {

            PreparedStatement stmt = r.prepareStatement("insert into user(name,surname,email,phone,profile_description,password) values(?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, crypt.hashToString(4, u.getPassword().toCharArray()));

            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }


}
