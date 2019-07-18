<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="mybean.Teacher" %>
<%@page import="mybean.Resource" %>
<jsp:useBean id="TeacherBean" type="mybean.Teacher" scope="session"/>
<jsp:getProperty name="Teacherbean" property="*"/>

<!DOCTYPE html>
<html>
    <head>
        <title>ManageFile Page</title>
    </head>
    <body>
<table>
    
    <tr>
        <th>资源编号：</th>
        <th>资源名称:</th>
        <th>资源所属课程:</th>
        <th>资源的操作:</th>
    </tr>
    
<%
    if(!TeacherBean.getResources().isEmpty()){
        Iterator<Resource> it = TeacherBean.getResources().iterator();
        while(it.hasNext()){
            Resource n = it.next();
    //只有当教学资源的share属性为1时才允许显示
            if(n.getRes_Share()==1){
%>
    <tr>
        <th><%=n.getRes_ID()%></th>
        <th><%=n.getRes_Name()%></th>
        <th><%=n.getRes_Clas_ID()%></th>
        <th><a href="/DeleteFile">删除</a><a href="/DoNotShareFile">撤销共享</a></th>
    </tr>
<%}}}
%>

</table>


<!--上传文件是主要功能-->
<a href="upload.jsp">上传文件</a>
<!--这里就只是转回主页面-->
<a href="教师主页面">返回教师主页面</a>
<!--转交给另一个Servlet收集教学组的所有共享资源-->
<a href="/MoreResource.jsp">more>></a>

    </body>
</html>