<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>Login</title>
    </head>
    <body>
    <center>
        <form action="LoginServlet" method="post">
        <table border="1">
            <tbody>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id" value="" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td>ѡ���������</td>
                    <td>
                        <input type="radio" name="identity" checked value="teacher"/>��ʦ
                        <input type="radio" name="identity" value="student"/>ѧ��
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="��¼"/>
        <input type="reset" value="���"/>
         </form>
        <a href="Register.jsp">���û�������ע��</a>
    </center>
    </body>
</html>
