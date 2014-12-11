/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.spe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INT303
 */
public class Customer {

    private int customerId;
    private String discountCode="N";
    private String zip;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String phone;
    private String email;
    private int creditLimit;
    private boolean isNew = true ;
    private static int NEXT_ID ;

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
  
    static {
        //execute once when class has been loaded
        NEXT_ID = getNewId();
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public static Customer findById(int id) {
        Customer c = null;
        try {
            Connection con = BuildConnection.getConnection();
            String sqlCmd = "select  * from customer where customer_id = ?";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Customer();
                getCustomer(rs, c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    private static void getCustomer(ResultSet rs, Customer c) throws SQLException {
        c.isNew = false;
        c.setCustomerId(rs.getInt("customer_id"));
        c.setEmail(rs.getString("email"));
        c.setZip(rs.getString("zip"));
        c.setName(rs.getString("name"));
        // added
        c.setDiscountCode(rs.getString("discount_code"));
        c.setAddressLine1(rs.getString("addressline1"));
        c.setAddressLine2(rs.getString("addressline2"));
        c.setCity(rs.getString("city"));
        c.setState(rs.getString("state"));
        c.setPhone(rs.getString("phone"));
        c.setCreditLimit(rs.getInt("credit_limit"));
    }

    public static List<Customer> findByName(String name) {
        Customer c = null;
        List<Customer> customers = null;
        try {
            Connection con = BuildConnection.getConnection();
            String sqlCmd = "select  * from customer where name like ?";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setString(1, name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                c = new Customer();
                getCustomer(rs, c);
                if (customers == null) {
                    customers = new ArrayList<Customer>();
                }
                customers.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return customers;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean save() {
        String sqlInsert = "insert into customer (discount_code, zip, name, addressLine1, addressLine2, "
                + "city, state, phone, email, credit_limit, customer_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlUpdate = "update customer set discount_code=?, zip=?, name=?, addressLine1=?, addressLine2=?, "
                + "city=?, state=?, phone=?, email=?, credit_limit=? where  customer_id = ?";
        try {
            Connection con = BuildConnection.getConnection();
            PreparedStatement stm = null;
            if (this.isNew) {
                stm = con.prepareStatement(sqlInsert);
                this.customerId = NEXT_ID ++;
            } else {
                stm = con.prepareStatement(sqlUpdate);
            }
            stm.setString(1, this.discountCode);
            stm.setString(2, this.zip);
            stm.setString(3, this.name);
            stm.setString(4, this.addressLine1);
            stm.setString(5, this.addressLine2);
            stm.setString(6, this.city);
            stm.setString(7, this.state);
            stm.setString(8, this.phone);
            stm.setString(9, this.email);
            stm.setInt(10, this.creditLimit);
            stm.setInt(11, this.customerId);
            int done = stm.executeUpdate();
            if (done>0) {
                isNew = false ;
            }
            return done > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    private static int getNewId() {
        try {
            Connection con = BuildConnection.getConnection();
            String sqlCmd = "select  customer_id from customer order by customer_id DESC FETCH FIRST 1 ROWS ONLY";
            ResultSet rs = con.createStatement().executeQuery(sqlCmd);
            if (rs.next()) {
                return rs.getInt(1)+1;
            } else {
                return -1;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
                return -1;
        }
        
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", discountCode=" + discountCode + ", zip=" + zip + ", name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", phone=" + phone + ", email=" + email + ", creditLimit=" + creditLimit + ", isNew=" + isNew + '}';
    }
}
