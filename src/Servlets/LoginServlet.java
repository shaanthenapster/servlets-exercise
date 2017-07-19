package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try
        {
            Bean po = new Bean();
            po.setUmail(request.getParameter("email"));
            po.setUpwd(request.getParameter("password"));
            po = Crud.loginUser(po);
            if(po.isValid()) {
                HttpSession session = request.getSession(true);
                pw.print(po.getUid());
                session.setAttribute("uid",po.getUid());
               response.sendRedirect("userLogged.jsp");
            }
            else {
                response.sendRedirect("InvalidLogin.jsp"); //error page );
            }
        }catch (Exception e){e.printStackTrace();}
    }
}

