<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="mybean.Teacher" %>
<%@page import="mybean.Classes" %>
<jsp:useBean id="TeacherBean" type="mybean.Teacher" scope="session"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传实例</title>
</head>
<body>
<h1>文件上传实例</h1>
<form method="post" action="UploadServlet" enctype="multipart/form-data">
    选择所属的课程：
<%  if(!TeacherBean.getClasses().isEmpty()){
        Iterator<Classes> it = TeacherBean.getClasses().iterator();
        while(it.hasNext()){
            Classes n = it.next();
}
%>

    <%}
%>
    选择一个文件:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
