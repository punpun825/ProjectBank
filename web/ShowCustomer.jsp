<%-- 
    Document   : ShowCustomer
    Created on : Sep 2, 2014, 1:53:43 PM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="info" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Info</title>
    </head>
    <body>
        <info:PageHeader title=":: Customer Information ::"/>
        <info:CustomerForm customer="${customer}" isReadOnly="true"/>
        <div align="center">
            <table width="90%">
                <tr>
                    <td align="center">
                        <a href="index.jsp"><input type="button" value=" Home "/></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="button" value=" Back " onclick="history.back(-1)"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="EditCustomer?id=${customer.customerId}"><input type="button" value=" Edit "/></a>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>  