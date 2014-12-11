<%-- 
    Document   : ListCustomer
    Created on : Sep 2, 2014, 2:18:58 PM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  tagdir="/WEB-INF/tags/" prefix="info" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <info:PageHeader title=":: Search Customer ::" />
        <jsp:include page="/SearchInput.jsp" flush="true"/>
        <hr>
            <info:ShowCustomer listOfCustomer="${customers}">
                <jsp:attribute name="headerFlagment">
                <tr bgColor="magenta">
                    <th>ลำดับที่</th><th>รหัสลูกค้า</th><th>ชื่อลูกค้า</th>
                    <th>Address Line1</th><th>Address Line2</th><th>City</th>
                    <th>State</th><th>Phone</th><th>Zip</th>
                    <th>eMail Address</th><th>Credit Limit</th><th>Discount Code</th>
                </tr>  
                 </jsp:attribute>
            </info:ShowCustomer>
    </body>
</html>
