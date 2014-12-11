/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.spe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import sit.int303.spe.model.Customer;
import sit.int303.spe.model.Util;

/**
 *
 * @author pichet
 */
public class UpdateCustomer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //getServletContext().getRequestDispatcher("/WEB-INF/jsp/SetCustomer.jsp").include(request, response);
        
        Customer customer = Util.parseCustomer(request);
        
        if (customer !=null) {
            boolean isNewCustomer = customer.isIsNew();
            boolean isSuccess = customer.save();
            if (isSuccess) {
                if (isNewCustomer) {
                    request.setAttribute("message", "Customer :" + customer.getName() + " has been Added");
                } else {
                    request.setAttribute("message", "Customer :" + customer.getName() + " has been updated");
                    request.setAttribute("customer", customer);
                }
            } else {
                request.setAttribute("message", "Can't save customer :" + customer.getName()+ 
                        "... Please see error in glassfish Log.)");
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/CustomerEntryForm.jsp").forward(request, response);
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
