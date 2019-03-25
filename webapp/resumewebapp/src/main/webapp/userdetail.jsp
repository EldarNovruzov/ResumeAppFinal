<%--
    Document   : user
    Created on : Feb 6, 2019, 8:20:34 PM
    Author     : Acer
--%>

<%@page import="com.mycompany.entity.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.main.dao.inter.CountryDaoInter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.entity.User"%>
<%@page import="com.mycompany.main.Context"%>
<%@page import="com.mycompany.main.dao.inter.UserDaoInter"%>
<%@ page import="com.mycompany.main.dao.inter.UserSkillDaoInter" %>
<%@ page import="com.mycompany.entity.UserSkill" %>
<%@ page import="com.mycompany.Dao.impl.UserSkillDaoImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/users.css">
    <title>JSP Page</title>
</head>
<body>

<%
    User u=(User)request.getAttribute("user");
    Integer idstr=Integer.parseInt(request.getParameter("id"));
    UserSkillDaoInter userskill =Context.instanceUserSkillDao();
    List<UserSkill> userskillList =userskill.getAllSkillByUserId(idstr);

%>
<div class="container">
    <div>
        <form action="userdetail" method="POST">
            <div class="col-4">
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <div class="form-group">
                    <label>name:</label>
                    <input placeholder="Enter name:" class="form-control" type="text" name="name" value="<%=u.getName()%>"/>
                </div>
                <input type="hidden" name="action" value="update">
                <div class="form-group">
                    <label>surname:</label>
                    <input placeholder="Enter surname:" class="form-control" type="text" name="surname" value="<%=u.getSurname()%>"/>
                </div>
                <input class="btn btn-primary" type="submit" name="save" value="Save"/>
            </div>
            <hr/>


        </form>
    </div>

    <div>
        <ul class="nav nav-tabs" role="tablist">
            <li class="active"><a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Details</a></li>
        </ul>

        <div class="tab-content">
            <div id="home" class="tab-pane fade show active">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>BirthDate</th>
                        <th>Country</th>
                        <th>Nationality</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getPhone()%></td>
                        <td><%=u.getAddress()%></td>
                        <td><%=u.getBirthDate()%></td>
                        <td><%=u.getBirthplace().getName()%></td>
                        <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>

                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="menu1" class="tab-pane fade active show">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Profile Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><%=u.getProfileDesc()%></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div id="menu2" class="tab-pane fade active show">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Skill Name</th>
                        <th>Power</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (UserSkill userSkill: userskillList) {
                    %>
                    <tr>
                        <td><%=userSkill.getSkill().getName()%></td>
                        <td><%=userSkill.getPower()%></td>
                    </tr>
                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>