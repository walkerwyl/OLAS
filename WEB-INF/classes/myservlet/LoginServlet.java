package myservlet;

import mybean.MyLogin;
import java.io.IOException;
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
        request.setCharacterEncoding("UTF-8");
        MyLogin rr = new MyLogin();
        HttpSession ss = request.getSession(true);
        ss.setAttribute("LoginBean", rr);
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
                if(rs.next()){
                    if(identity.equals("teacher")){
                        rr.setName(rs.getString(1));
                        rr.setFlag("Welcome "+rs.getString(1));
                        rr.setSs(true);
                        ss.setAttribute("id", id);
                        RequestDispatcher dis = request.getRequestDispatcher("Tea_Homepage.jsp");
                        dis.forward(request, response);
                    }
                    else{
                        rr.setName(rs.getString(1));
                        rr.setFlag("Welcome "+rs.getString(1));
                        rr.setSs(true);
                        ss.setAttribute("id", id);
                        RequestDispatcher dis = request.getRequestDispatcher("Stu_Homepage.jsp");
                        dis.forward(request, response);
                    }
                }else{
                    rr.setFlag("Wrong id or password!");
                    RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
                    dis.forward(request, response);
                }
            }
            catch(Exception e){};
        }else{
            rr.setFlag("id or password can not be null");
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
