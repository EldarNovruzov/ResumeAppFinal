//package com.company.resume.controller;
//
//import com.mycompany.entity.AdminLogin;
//import com.mycompany.main.Context;
//import com.mycompany.main.dao.inter.AdminLoginDaoInter;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@WebServlet(name = "AdminLogincontroller", urlPatterns = "/adminlogin")
//public class AdminLogincontroller extends HttpServlet {
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException,
//            java.io.IOException {
//        try {
//            String email = req.getParameter("email");
//            String password = req.getParameter("password");
//            AdminLoginDaoInter login = Context.instanceAdminLoginDao();
//            List<AdminLogin> adminlogin = login.getAll();
//            for (AdminLogin al : adminlogin) {
//                if (!email.equals(al.getLoginEmail()) && !(password.equals(al.getLoginpassword()))) {
//                   throw new IllegalArgumentException("Please enter the correct email and password:");
//                }else if(!(password.equals(al.getLoginpassword()))){
//                   throw new IllegalArgumentException("Please enter the correct password:");
//               }else if (!email.equals(al.getLoginEmail())){
//                   throw new IllegalArgumentException("Please enter the correct email:");
//                }
//                resp.sendRedirect("users");
//            }
//        }catch(Exception ex){
//            resp.sendRedirect("error?msg="+ex.getMessage());
//        }
//    }
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException,
//            java.io.IOException {
//        req.getRequestDispatcher("adminlogin.jsp").forward(req,resp);
//    }
//
//}
