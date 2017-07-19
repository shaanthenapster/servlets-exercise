package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by shaan on 29/6/17.
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("userLogged.jsp");
        PrintWriter pw = response.getWriter();
        Integer uid=(Integer) request.getSession().getAttribute("uid");
        String blog = request.getParameter("blog");
        Bean bean = new Bean();
        bean.setBlog(blog);
        bean.setUid(uid);
        int status = Crud.insertblog(bean);
        if (status > 0) {
            pw.print("<p> record saved successfully </p>");
            requestDispatcher.include(request,response);

        } else {
            pw.println("Sorry! unable to save record");
        }
    }
}
