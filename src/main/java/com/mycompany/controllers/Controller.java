package com.mycompany.controllers;

import com.mycompany.entities.Department;
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
            Long dept_id = null;
        
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String date = request.getParameter("hireDate");
            String phoneNumber = request.getParameter("phoneNumber");
            Double monthlySalary = Double.valueOf(request.getParameter("monthlySalary"));
            String dept = request.getParameter("department");
            
            
            switch (dept) {
                case "HR" -> dept_id=1L;
                case "IT" -> dept_id=2L;
                case "Finance" -> dept_id=3L;
                case "Marketing" -> dept_id=4L;
                default -> {
                }
            }

                Department department = new Department();
                Employee employee = new Employee();
            
                department.setName(dept);
                department.setDept_id(dept_id);
            
            
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setMonthlySalary(monthlySalary);
                Date dt = null;
                try {
                    dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                employee.setHireDate(dt);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setDepartment(department);
             
   
            try {
            userTransaction.begin();
            em.persist(employee);
            userTransaction.commit();
             } catch (NotSupportedException | 
                SystemException | RollbackException | 
                HeuristicMixedException | HeuristicRollbackException | 
                SecurityException | IllegalStateException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The user " + employee.getFirstName() + " has been registered </h1>");
            out.println("</body>");
            out.println("</html>");

       

    }

}