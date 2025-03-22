package com.mycompany.controllers;

import com.mycompany.entities.Employee;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String first_name = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String date = request.getParameter("hireDate");
            String phoneNumber = request.getParameter("phoneNumber");
            Double monthlySalary = Double.valueOf(request.getParameter("monthlySalary"));

            Employee emp = new Employee();
            emp.setFirstName(first_name);
            emp.setLastName(lastName);
            emp.setSalary(monthlySalary);

            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            emp.setHireDate(dt);
            emp.setEmail(email);
            emp.setPhoneNumber(phoneNumber);
            
            userTransaction.begin();
            em.persist(emp);
            userTransaction.commit();

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The user " + emp.getFirstName() + " has been registered </h1>");
            out.println("</body>");
            out.println("</html>");

        } catch (ParseException | NotSupportedException | 
                SystemException | RollbackException | 
                HeuristicMixedException | HeuristicRollbackException | 
                SecurityException | IllegalStateException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}