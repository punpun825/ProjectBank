/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sit.int303.spe.model;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author INT303
 */
public class Util {
    public static boolean isInteger(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static Customer parseCustomer(HttpServletRequest request) {
        String name = request.getParameter("name") ;
        if (name == null || name.length()==0) {
            return null ;
        } else {
            Customer c = new Customer();
            String id = request.getParameter("customerId");
            if (isInteger(id)) {
                int customerId = Integer.parseInt(id);
                c.setIsNew(false);
                c.setCustomerId(customerId);
            }
            c.setName(name);
            c.setAddressLine1(request.getParameter("addressLine1"));
            c.setAddressLine2(request.getParameter("addressLine2"));
            c.setCity(request.getParameter("city"));
            c.setCreditLimit(Integer.parseInt(request.getParameter("creditLimit")));
            c.setDiscountCode(request.getParameter("discountCode"));
            c.setEmail(request.getParameter("email"));
            c.setPhone(request.getParameter("phone"));
            c.setState(request.getParameter("state"));
            c.setZip(request.getParameter("zip"));
            request.getServletContext().log(c.toString());
            return  c;
        }
    }
}
