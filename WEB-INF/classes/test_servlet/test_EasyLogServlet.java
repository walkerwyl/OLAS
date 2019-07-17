/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class test_EasyLogServlet {
    public static void main(String[] args) {
        Connection con;
        Statement sql;
        ResultSet rs;
        try{
            String uri = "jdbc:mysql://127.0.0.1/OLAS_DB?user=root&password=41710020wys&characterEncoding=gb2312&useSSL=true&serverTimezone=UTC";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
//            rs = sql.executeQuery("SELECT * FROM teacher");
//            Tes_ID是否存在？数据库条件查询
            rs = sql.executeQuery("SELECT * FROM teacher where Tes_ID =''");
//            进行查找,如果ID存在则转向个人主页
//              否则重定向到登陆界面
            if(!rs.next()){
                System.out.println("在数据库中没有这个ID");
            }else{
                System.out.println("在数据库中确实有这个ID");
            }

        }
        catch(SQLException e) {
            System.out.println("存在错误！！！");
            System.out.println(e);
        }
    }
}
