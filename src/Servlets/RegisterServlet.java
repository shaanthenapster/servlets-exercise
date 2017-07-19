package Servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shaan on 27/6/17.
 */
@WebServlet("/hell")
public class RegisterServlet extends HttpServlet {
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String number=request.getParameter("number");
        String password=request.getParameter("password");
        Bean po = new Bean();
        po.setUname(name);
        po.setUmail(email);
        po.setUnumber(number);
        po.setUpwd(password);
        int status = Crud.registerUser(po);
        if(status > 0)
        {
            pw.print("<p> record saved successfully </p>");

        }
    else{
        pw.println("Sorry! unable to save record");
    }

        pw.close();

}
}




