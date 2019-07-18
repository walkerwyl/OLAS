package myservlet;

import mybean.student_bean;
import mybean.teacher_bean;
import mybean.class_bean;
import mybean.source_bean;
import mybean.info_bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");   //解决乱码所必须的
        HttpSession ss = request.getSession(true);
        
        String id = request.getParameter("id");
        String pwd = request.getParameter("password");
        String identity = request.getParameter("identity");
        
        if(!id.equals(null)&&!pwd.equals(null)){
  
            try{
                PreparedStatement ps;
                if(identity.equals("teacher")){
                    ps = DB.dbCon().prepareStatement("select * from teacher where Tea_ID=? and Password=?");
                }
                else{
                    ps = DB.dbCon().prepareStatement("select * from student where Stu_ID=? and Password=?");
                }
                ps.setInt(1, Integer.parseInt(id));
                ps.setString(2, pwd);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){//如果登陆成功
                    if(identity.equals("teacher")){//是教师登录则修改相关bean后转到教师主页
                        teacher_bean tea = new teacher_bean();
                        ss.setAttribute("TeacherBean", tea);
                        
                        tea.setName(rs.getString(1));
                        tea.setTea_ID(rs.getString(2));
                        tea.setGender(rs.getInt(3));
                        
                        
                        ps = DB.dbCon().prepareStatement("select * from source where Tea_ID=?");
                        ps.setInt(1, Integer.parseInt(id));
                        rs = ps.executeQuery();
                        
                        if(rs.next()){
                            source_bean source1 = new source_bean();
                            source1.setTea_ID(rs.getString(1));
                            source1.setCou_ID(rs.getString(2));
                            source1.setType(rs.getInt(3));
                            source1.setSou_ID(rs.getString(4));
                            source1.setSum_Count(rs.getInt(5));
                            source1.setSou_Name(rs.getString(6));
                            source1.setShare(rs.getInt(7));
                            tea.sources.add(source1);
                        }
                        if(rs.next()){
                            source_bean source2 = new source_bean();
                            source2.setTea_ID(rs.getString(1));
                            source2.setCou_ID(rs.getString(2));
                            source2.setType(rs.getInt(3));
                            source2.setSou_ID(rs.getString(4));
                            source2.setSum_Count(rs.getInt(5));
                            source2.setSou_Name(rs.getString(6));
                            source2.setShare(rs.getInt(7));
                            tea.sources.add(source2);
                        }
                        if(rs.next()){
                            source_bean source3 = new source_bean();
                            source3.setTea_ID(rs.getString(1));
                            source3.setCou_ID(rs.getString(2));
                            source3.setType(rs.getInt(3));
                            source3.setSou_ID(rs.getString(4));
                            source3.setSum_Count(rs.getInt(5));
                            source3.setSou_Name(rs.getString(6));
                            source3.setShare(rs.getInt(7));
                            tea.sources.add(source3);
                        }
                        if(rs.next()){
                            source_bean source4 = new source_bean();
                            source4.setTea_ID(rs.getString(1));
                            source4.setCou_ID(rs.getString(2));
                            source4.setType(rs.getInt(3));
                            source4.setSou_ID(rs.getString(4));
                            source4.setSum_Count(rs.getInt(5));
                            source4.setSou_Name(rs.getString(6));
                            source4.setShare(rs.getInt(7));
                            tea.sources.add(source4);
                        }
                        if(rs.next()){
                            source_bean source5 = new source_bean();
                            source5.setTea_ID(rs.getString(1));
                            source5.setCou_ID(rs.getString(2));
                            source5.setType(rs.getInt(3));
                            source5.setSou_ID(rs.getString(4));
                            source5.setSum_Count(rs.getInt(5));
                            source5.setSou_Name(rs.getString(6));
                            source5.setShare(rs.getInt(7));
                            tea.sources.add(source5);
                        }
                        if(rs.next()){
                            source_bean source6 = new source_bean();
                            source6.setTea_ID(rs.getString(1));
                            source6.setCou_ID(rs.getString(2));
                            source6.setType(rs.getInt(3));
                            source6.setSou_ID(rs.getString(4));
                            source6.setSum_Count(rs.getInt(5));
                            source6.setSou_Name(rs.getString(6));
                            source6.setShare(rs.getInt(7));
                            tea.sources.add(source6);
                        }
                        if(rs.next()){
                            source_bean source7 = new source_bean();
                            source7.setTea_ID(rs.getString(1));
                            source7.setCou_ID(rs.getString(2));
                            source7.setType(rs.getInt(3));
                            source7.setSou_ID(rs.getString(4));
                            source7.setSum_Count(rs.getInt(5));
                            source7.setSou_Name(rs.getString(6));
                            source7.setShare(rs.getInt(7));
                            tea.sources.add(source7);
                        }
                        if(rs.next()){
                            source_bean source8 = new source_bean();
                            source8.setTea_ID(rs.getString(1));
                            source8.setCou_ID(rs.getString(2));
                            source8.setType(rs.getInt(3));
                            source8.setSou_ID(rs.getString(4));
                            source8.setSum_Count(rs.getInt(5));
                            source8.setSou_Name(rs.getString(6));
                            source8.setShare(rs.getInt(7));
                            tea.sources.add(source8);
                        }
                        if(rs.next()){
                            source_bean source9 = new source_bean();
                            source9.setTea_ID(rs.getString(1));
                            source9.setCou_ID(rs.getString(2));
                            source9.setType(rs.getInt(3));
                            source9.setSou_ID(rs.getString(4));
                            source9.setSum_Count(rs.getInt(5));
                            source9.setSou_Name(rs.getString(6));
                            source9.setShare(rs.getInt(7));
                            tea.sources.add(source9);
                        }
                        if(rs.next()){
                            source_bean source10 = new source_bean();
                            source10.setTea_ID(rs.getString(1));
                            source10.setCou_ID(rs.getString(2));
                            source10.setType(rs.getInt(3));
                            source10.setSou_ID(rs.getString(4));
                            source10.setSum_Count(rs.getInt(5));
                            source10.setSou_Name(rs.getString(6));
                            source10.setShare(rs.getInt(7));
                            tea.sources.add(source10);
                        }
                        
                        ps = DB.dbCon().prepareStatement("select * from class where Tea_ID=?");
                        ps.setInt(1, Integer.parseInt(id));
                        rs = ps.executeQuery();
                        
                        if(rs.next()){
                            class_bean class1 = new class_bean();
                            class1.setCou_ID(rs.getString(1));
                            class1.setClass_ID(rs.getString(2));
                            class1.setCou_Name(rs.getString(3));
                            class1.setTea_ID(rs.getString(4));
                            tea.classes.add(class1);
                        }
                        if(rs.next()){
                            class_bean class2 = new class_bean();
                            class2.setCou_ID(rs.getString(1));
                            class2.setClass_ID(rs.getString(2));
                            class2.setCou_Name(rs.getString(3));
                            class2.setTea_ID(rs.getString(4));
                            tea.classes.add(class2);
                        }
                        if(rs.next()){
                            class_bean class3 = new class_bean();
                            class3.setCou_ID(rs.getString(1));
                            class3.setClass_ID(rs.getString(2));
                            class3.setCou_Name(rs.getString(3));
                            class3.setTea_ID(rs.getString(4));
                            tea.classes.add(class3);
                        }
                        if(rs.next()){
                            class_bean class4 = new class_bean();
                            class4.setCou_ID(rs.getString(1));
                            class4.setClass_ID(rs.getString(2));
                            class4.setCou_Name(rs.getString(3));
                            class4.setTea_ID(rs.getString(4));
                            tea.classes.add(class4);
                        }
                        if(rs.next()){
                            class_bean class5 = new class_bean();
                            class5.setCou_ID(rs.getString(1));
                            class5.setClass_ID(rs.getString(2));
                            class5.setCou_Name(rs.getString(3));
                            class5.setTea_ID(rs.getString(4));
                            tea.classes.add(class5);
                        }
                        if(rs.next()){
                            class_bean class6 = new class_bean();
                            class6.setCou_ID(rs.getString(1));
                            class6.setClass_ID(rs.getString(2));
                            class6.setCou_Name(rs.getString(3));
                            class6.setTea_ID(rs.getString(4));
                            tea.classes.add(class6);
                        }
                        if(rs.next()){
                            class_bean class7 = new class_bean();
                            class7.setCou_ID(rs.getString(1));
                            class7.setClass_ID(rs.getString(2));
                            class7.setCou_Name(rs.getString(3));
                            class7.setTea_ID(rs.getString(4));
                            tea.classes.add(class7);
                        }
                        if(rs.next()){
                            class_bean class8 = new class_bean();
                            class8.setCou_ID(rs.getString(1));
                            class8.setClass_ID(rs.getString(2));
                            class8.setCou_Name(rs.getString(3));
                            class8.setTea_ID(rs.getString(4));
                            tea.classes.add(class8);
                        }
                        if(rs.next()){
                            class_bean class9 = new class_bean();
                            class9.setCou_ID(rs.getString(1));
                            class9.setClass_ID(rs.getString(2));
                            class9.setCou_Name(rs.getString(3));
                            class9.setTea_ID(rs.getString(4));
                            tea.classes.add(class9);
                        }
                        if(rs.next()){
                            class_bean class10 = new class_bean();
                            class10.setCou_ID(rs.getString(1));
                            class10.setClass_ID(rs.getString(2));
                            class10.setCou_Name(rs.getString(3));
                            class10.setTea_ID(rs.getString(4));
                            tea.classes.add(class10);
                        }
                        
                        RequestDispatcher dis = request.getRequestDispatcher("Tea_Homepage.jsp");
                        dis.forward(request, response);
                    }
                    
                    else{//否则是学生登录，则修改相关bean后转到学生主页
                        student_bean stu = new student_bean();
                        ss.setAttribute("StudentBean", stu);
                        
                        stu.setName(rs.getString(1));
                        stu.setStu_ID(rs.getString(2));
                        stu.setGender(rs.getInt(4));
                        
                        
                        ps = DB.dbCon().prepareStatement("select * from info where Stu_ID=?");
                        ps.setInt(1, Integer.parseInt(id));
                        rs = ps.executeQuery();
                        
                        if(rs.next()){
                            info_bean info1 = new info_bean();
                            info1.setClass_ID(rs.getString(1));
                            info1.setStu_ID(rs.getString(2));
                            info1.setWork1(rs.getFloat(3));
                            info1.setWork2(rs.getFloat(4));
                            info1.setWork3(rs.getFloat(5));
                            info1.setMy_Count(rs.getInt(6));
                            info1.setMy_Time(rs.getInt(7));
                            info1.setStu_Name(rs.getString(8));
                            stu.infos.add(info1);
                        }
                        
                        if(rs.next()){
                            info_bean info2 = new info_bean();
                            info2.setClass_ID(rs.getString(1));
                            info2.setStu_ID(rs.getString(2));
                            info2.setWork1(rs.getFloat(3));
                            info2.setWork2(rs.getFloat(4));
                            info2.setWork3(rs.getFloat(5));
                            info2.setMy_Count(rs.getInt(6));
                            info2.setMy_Time(rs.getInt(7));
                            info2.setStu_Name(rs.getString(8));
                            stu.infos.add(info2);
                        }
                        if(rs.next()){
                            info_bean info3 = new info_bean();
                            info3.setClass_ID(rs.getString(1));
                            info3.setStu_ID(rs.getString(2));
                            info3.setWork1(rs.getFloat(3));
                            info3.setWork2(rs.getFloat(4));
                            info3.setWork3(rs.getFloat(5));
                            info3.setMy_Count(rs.getInt(6));
                            info3.setMy_Time(rs.getInt(7));
                            info3.setStu_Name(rs.getString(8));
                            stu.infos.add(info3);
                        }
                        if(rs.next()){
                            info_bean info4 = new info_bean();
                            info4.setClass_ID(rs.getString(1));
                            info4.setStu_ID(rs.getString(2));
                            info4.setWork1(rs.getFloat(3));
                            info4.setWork2(rs.getFloat(4));
                            info4.setWork3(rs.getFloat(5));
                            info4.setMy_Count(rs.getInt(6));
                            info4.setMy_Time(rs.getInt(7));
                            info4.setStu_Name(rs.getString(8));
                            stu.infos.add(info4);
                        }
                        if(rs.next()){
                            info_bean info5 = new info_bean();
                            info5.setClass_ID(rs.getString(1));
                            info5.setStu_ID(rs.getString(2));
                            info5.setWork1(rs.getFloat(3));
                            info5.setWork2(rs.getFloat(4));
                            info5.setWork3(rs.getFloat(5));
                            info5.setMy_Count(rs.getInt(6));
                            info5.setMy_Time(rs.getInt(7));
                            info5.setStu_Name(rs.getString(8));
                            stu.infos.add(info5);
                        }
                        if(rs.next()){
                            info_bean info6 = new info_bean();
                            info6.setClass_ID(rs.getString(1));
                            info6.setStu_ID(rs.getString(2));
                            info6.setWork1(rs.getFloat(3));
                            info6.setWork2(rs.getFloat(4));
                            info6.setWork3(rs.getFloat(5));
                            info6.setMy_Count(rs.getInt(6));
                            info6.setMy_Time(rs.getInt(7));
                            info6.setStu_Name(rs.getString(8));
                            stu.infos.add(info6);
                        }
                        if(rs.next()){
                            info_bean info7 = new info_bean();
                            info7.setClass_ID(rs.getString(1));
                            info7.setStu_ID(rs.getString(2));
                            info7.setWork1(rs.getFloat(3));
                            info7.setWork2(rs.getFloat(4));
                            info7.setWork3(rs.getFloat(5));
                            info7.setMy_Count(rs.getInt(6));
                            info7.setMy_Time(rs.getInt(7));
                            info7.setStu_Name(rs.getString(8));
                            stu.infos.add(info7);
                        }
                        if(rs.next()){
                            info_bean info8 = new info_bean();
                            info8.setClass_ID(rs.getString(1));
                            info8.setStu_ID(rs.getString(2));
                            info8.setWork1(rs.getFloat(3));
                            info8.setWork2(rs.getFloat(4));
                            info8.setWork3(rs.getFloat(5));
                            info8.setMy_Count(rs.getInt(6));
                            info8.setMy_Time(rs.getInt(7));
                            info8.setStu_Name(rs.getString(8));
                            stu.infos.add(info8);
                        }
                        if(rs.next()){
                            info_bean info9 = new info_bean();
                            info9.setClass_ID(rs.getString(1));
                            info9.setStu_ID(rs.getString(2));
                            info9.setWork1(rs.getFloat(3));
                            info9.setWork2(rs.getFloat(4));
                            info9.setWork3(rs.getFloat(5));
                            info9.setMy_Count(rs.getInt(6));
                            info9.setMy_Time(rs.getInt(7));
                            info9.setStu_Name(rs.getString(8));
                            stu.infos.add(info9);
                        }
                        if(rs.next()){
                            info_bean info10 = new info_bean();
                            info10.setClass_ID(rs.getString(1));
                            info10.setStu_ID(rs.getString(2));
                            info10.setWork1(rs.getFloat(3));
                            info10.setWork2(rs.getFloat(4));
                            info10.setWork3(rs.getFloat(5));
                            info10.setMy_Count(rs.getInt(6));
                            info10.setMy_Time(rs.getInt(7));
                            info10.setStu_Name(rs.getString(8));
                            stu.infos.add(info10);
                        }

                        
                        RequestDispatcher dis = request.getRequestDispatcher("Stu_Homepage.jsp");
                        dis.forward(request, response);
                    }
                }else{
                    //rr.setFlag("Wrong id or password!");
                    RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
                    dis.forward(request, response);
                }
            }
            catch(Exception e){};
        }else{
            //rr.setFlag("id or password can not be null");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}