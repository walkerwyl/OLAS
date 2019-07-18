/*
 * 初始化一个完整的teacher对象，不仅包含有ID，而且包含有与之有关的资源等数据
 */
package myservlet;

import mybean.Resource;
import mybean.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class ManageFileServlet extends HttpServlet {

    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
    }
//    根据主页面传递的老师的ID，连接数据库并从中获得相关的数据

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Tea_ID = "walker";

        Resource resource = null;

        Connection con;
        Statement sql;
        ResultSet rs;
        try {
            String uri = "jdbc:mysql://127.0.0.1/OLAS_DB?" + "user=root&&password=41710020wys&characterEncoding=gb2312&useSSL=true&serverTimezone=UTC";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
//          根据教师ID得到老师对应的资源列表
            rs = sql.executeQuery("SELECT * FROM resource where Res_Tes_ID='" + Tea_ID + "'");
            if (!rs.next()) {
//          这时教师没有上传资源为空  
            } else {
//          此时教师已经上传过资源，不为空，资源信息循环赋值的形式存储在老师的JavaBean中的对应数组中，然后在ManageFile.jsp页面中显示
//          将存有完整信息的老师的JavaBean传递给ManageFile.jsp中用于数据的显示
//          此处逻辑关系复杂，数据库方面需要更多的资料
//          
            int i=1;
            do{
                
            }while(!rs.next());
            












            }
        } catch (SQLException e) {
//            System.out.println();
        }
    }
}
