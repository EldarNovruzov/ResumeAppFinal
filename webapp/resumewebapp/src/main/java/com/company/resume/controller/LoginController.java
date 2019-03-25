package com.company.resume.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.resume.util.ControllerUtil;
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
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private UserDaoInter userDao= Context.instanceUserDao();
    private BCrypt.Hasher crypt= BCrypt.withDefaults();
    private  static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDao.findByEmail(email);
            System.out.println(user);

            if (user == null) {
                throw new IllegalArgumentException("User doesn't exist!!!");
            }
            BCrypt.Result rs= verifyer.verify(password.toCharArray(),user.getPassword().toCharArray());

            if (!rs.verified){
                throw new IllegalArgumentException("Password is incorrect");
            }

            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("users");
        }catch (Exception ex){
            ControllerUtil.errorPage(response,ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }


}