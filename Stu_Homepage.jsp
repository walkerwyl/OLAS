<%@page import="java.util.Iterator"%>
<%@page import="mybean.student_bean"%>
<%@page import="mybean.info_bean"%>
<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<jsp:useBean id="StudentBean" type="mybean.student_bean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>ѧ����ҳ</title>
    </head>
    <body>
        <br><a href="ChangePassword.jsp">�޸�����>>>>>></a>
        ����:<jsp:getProperty name="StudentBean" property="name"/>
        �Ա�:<jsp:getProperty name="StudentBean" property="gender"/>
        
        <%
            Iterator<info_bean> it = StudentBean.infos.iterator();	
                while (it.hasNext()) {		
                    info_bean n = it.next();
                    %>
                    �ɼ�1��<%=n.getWork1()%>
                    �ɼ�2��<%=n.getWork2()%>
                    �ɼ�3��<%=n.getWork3()%>
                    <%
                }
        %>
    </body>
</html>