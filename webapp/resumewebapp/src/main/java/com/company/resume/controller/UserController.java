package com.company.resume.controller;

import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.main.dao.inter.UserDaoInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Acer
 */
@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserDaoInter userDao = Context.instanceUserDao();
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String nationId=request.getParameter("nationalityId");

        Integer nationalityIdbyRequest=null;
        if (nationId!=null && !nationId.trim().isEmpty()){
            nationalityIdbyRequest=Integer.parseInt(nationId);
        }
        List<User> list= userDao.getAll(name,surname,nationalityIdbyRequest);
        request.setAttribute("list",list);
        request.getRequestDispatcher("users.jsp").forward(request,response);

    }


}
