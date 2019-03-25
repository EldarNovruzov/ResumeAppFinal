package com.company.resume.controller;

import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.main.dao.inter.UserDaoInter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDaoInter userDao = Context.instanceUserDao();
        int id = Integer.valueOf(request.getParameter("id"));
        String action=request.getParameter("action");
        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            User user = userDao.getbyID(id);

            user.setName(name);
            user.setSurname(surname);


            userDao.updateUser(user);
        }else if(action.equals("delete")){
            userDao.removeUser(id);
        }
        response.sendRedirect("users");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            User u = null;
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
//            request.setAttribute("msg","specify Id");
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(request.getParameter("id"));
            UserDaoInter userDao = Context.instanceUserDao();
            u = userDao.getbyID(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("user",u);
            request.getRequestDispatcher("userdetail.jsp").forward(request,response);
        }catch(Exception ex){
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }

    }


}