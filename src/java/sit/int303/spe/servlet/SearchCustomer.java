/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.spe.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sit.int303.spe.model.Customer;
import sit.int303.spe.model.Util;

/**
 *
 * @author INT303
 */
public class SearchCustomer extends HttpServlet {

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
        int id = 0;
        String para = request.getParameter("id");
        String message = null;
        if (para == null) {
            getServletContext().getRequestDispatcher("/SearchCustomer.jsp").forward(request, response);
        } else if (Util.isInteger(para)) {
            id = Integer.parseInt(request.getParameter("id"));
            Customer c = Customer.findById(id);
            if (c != null) {
                request.setAttribute("customer", c);
                getServletContext().getRequestDispatcher("/ShowCustomer.jsp").forward(request, response);
                return;
            } else {
                message = "Customer id  '" + id + "' does not exist !!!";
            }
        } else {
            List<Customer> customers = Customer.findByName(para);
            if (customers != null) {
                request.setAttribute("customers", customers);
                getServletContext().getRequestDispatcher("/ListCustomer.jsp").forward(request, response);
                return;
            } else {
                message = "Customer name  '" + para + "' does not exist !!!";
            }
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
