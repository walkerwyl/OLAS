<%@page import="java.util.Iterator"%>
<%@page import="mybean.class_bean"%>
<%@page import="mybean.source_bean"%>
<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<jsp:useBean id="TeacherBean" type="mybean.teacher_bean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>��ʦ��ҳ</title>
    </head>
    <body>
        
        ����:<jsp:getProperty name="TeacherBean" property="name"/>
        ID:<jsp:getProperty name="TeacherBean" property="tea_id"/>
        �Ա�:<jsp:getProperty name="TeacherBean" property="gender"/>
        
        <%
            Iterator<class_bean> it = TeacherBean.classes.iterator();	
                while (it.hasNext()) {		
                    class_bean n = it.next();
                    %>
                    �ɼ�1��<%=%>
                    �ɼ�2��<%=%>
                    �ɼ�3��<%=%>
                    <%
                }
            Iterator<source_bean> it1 = TeacherBean.sources.iterator();	
                while (it.hasNext()) {		
                    source_bean n = it1.next();
                    %>
                    �ɼ�1��<%=%>
                    �ɼ�2��<%=%>
                    �ɼ�3��<%=%>
                    <%
                }
        %>
            <br><a href="ChangePassword.jsp">�޸�����>>>>>></a>
    </body>
</html>