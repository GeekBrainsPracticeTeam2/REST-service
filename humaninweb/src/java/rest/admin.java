package rest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "admin", urlPatterns = {"/admin"})

public class admin extends HttpServlet {
     public static String sites;
     public static String lastdate;
     public static String persons;
     public static String personsadd;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
       response.setCharacterEncoding("UTF8");
       request.setCharacterEncoding("UTF8");
       
       response.setContentType("application/json");
       
       sites = request.getParameter("sites");
       lastdate = request.getParameter("lastdate");
       persons = request.getParameter("persons");
       
       if(lastdate!=null && lastdate.equals("get")){
           database.DataBase.lastDate();
           response.getWriter().write(json.Json.objLastDate.toString());
        }
       
       if(sites!=null && sites.equals("get")){
          database.DataBase.sites(); 
          response.getWriter().write(json.Json.objSites.toString());
       }
       
       if(persons != null && persons.equals("get")){
           
               database.DataBase.persons();
               response.getWriter().write(json.Json.objPersons.toString());
       
        }
       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
       response.setCharacterEncoding("UTF8");
       request.setCharacterEncoding("UTF8");
       
       personsadd = request.getParameter("personsadd");
       
       if(personsadd != null){
           database.DataBase.baseInsert(personsadd);
           response.getWriter().write(personsadd);
           
       }
       
       
       
    }
}

