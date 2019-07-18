<%@page import="java.util.Iterator"%>
<%@page import="mybean.class_bean"%>
<%@page import="mybean.source_bean"%>
<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<jsp:useBean id="TeacherBean" type="mybean.teacher_bean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>教师主页</title>
    </head>
    <body>
        
        名字:<jsp:getProperty name="TeacherBean" property="name"/>
        ID:<jsp:getProperty name="TeacherBean" property="tea_id"/>
        性别:<jsp:getProperty name="TeacherBean" property="gender"/>
        
        <%
            Iterator<class_bean> it = TeacherBean.classes.iterator();	
                while (it.hasNext()) {		
                    class_bean n = it.next();
                    %>
                    成绩1：<%=%>
                    成绩2：<%=%>
                    成绩3：<%=%>
                    <%
                }
            Iterator<source_bean> it1 = TeacherBean.sources.iterator();	
                while (it.hasNext()) {		
                    source_bean n = it1.next();
                    %>
                    成绩1：<%=%>
                    成绩2：<%=%>
                    成绩3：<%=%>
                    <%
                }
        %>
            <br><a href="ChangePassword.jsp">修改密码>>>>>></a>
    </body>
</html>