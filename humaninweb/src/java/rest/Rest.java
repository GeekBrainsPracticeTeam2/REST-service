
package rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "Rest", urlPatterns = {"/Rest"})

public class Rest extends HttpServlet {
    public static String namehuman;
    public static String sitedest;
    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setCharacterEncoding("UTF8");
       request.setCharacterEncoding("UTF8");
       
       response.setContentType("application/json");
       
       namehuman = request.getParameter("name");
       sitedest = request.getParameter("site");
       
       response.getWriter().write(json.Json.objPersons.toString());
        
       }

  

}
