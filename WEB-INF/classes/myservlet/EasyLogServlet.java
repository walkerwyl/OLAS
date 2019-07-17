package myservlet;

import mybean.Log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EasyLogServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log person = new Log();
//        Teacher teacher = null;
//        try{    teacher = (Teacher)request.getAttribute("teacher");
//                if(teacher==null){
//                    teacher = new Teacher();
//                    request.setAttribute("teacher", teacher);
//                }
//        }
//        catch(Exception e){
//            teacher = new Teacher();
//            request.setAttribute("teacher", teacher);
//        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EasyLogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("person", person);
        try {
            String ID = request.getParameter("ID");
            person.setID(ID);
        } catch (Exception e) {
        }
//        至此获得用户的ID等数据，连接数据库准备查找老师的资源
        Connection con;
        Statement sql;
        ResultSet rs;
        try {
            String uri = "jdbc:mysql://127.0.0.1/OLAS_DB?user=root&password=41710020wys&characterEncoding=gb2312&useSSL=true&serverTimezone=UTC";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
//            rs = sql.executeQuery("SELECT * FROM teacher");
//            ID是否存在？数据库条件查询
//          根据那个按钮的选项决定在哪一张表中查看数据并检验密码
            rs = sql.executeQuery("SELECT * FROM teacher where Tes_ID ='" + person.getID() + "'");
//            进行查找,如果ID存在则将EasyLog.jsp对EasyLogServlet.java的请求转发到ManageFileServlet.java并由其进行相关信息的初始化工作
//              否则重定向到登陆界面
            if (!rs.next()) {
//                System.out.println("在数据库中没有这个ID");
                response.sendRedirect("EasyLog.jsp");
            } else {
//                System.out.println("在数据库中确实有这个ID");
//              从数据库中查取数据，对相关的数据进行初始化，比如老师的姓名、所教授的班级、所发送的资源以及资源的相关信息都及时调入内存，并保存在JavaBean(session)中以备调用

                RequestDispatcher dispatcher = request.getRequestDispatcher("ManageFile.jsp");
            }

        } catch (SQLException e) {
//            System.out.println("存在错误！！！");
//            System.out.println(e);
        }

    }
}
