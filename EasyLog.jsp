<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mybean.Log" %>
<jsp:useBean id="person" class="mybean.Log"scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyLog Page</title>
    </head>
    <body>
        <form action="EasyLogServlet" method="post">
            <input type="text" name="ID" size="4">
            <input type="text" name="passwd" size="4">
            <!--仅用于获取教师的ID进行测试-->
            <input type="submit" value="Log in">
        </form>
        <%
            String ID = request.getParameter("ID");
            if(ID==null)
                ID="";
            else
                session.setAttribute("ID", ID);
        %>
        <jsp:setProperty name="person" property="*"/>
        <!--在提交给登录页面控制器的同时将response发送给-->
        <%--<%response.sendRedirect("ManageFileServlet");%>--%>
    </body>
</html>
