

<%-- 
    Document   : Login
    Created on : Oct 24, 2014, 11:52:31 AM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="info" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="document.getElementById('userId').focus()">
        <info:PageHeader title="Login to CO System"/>
        <form action="<%= response.encodeURL("Login")%>" method="post"/>
        <table>
            <tr>
                <td>User Id</td>
                <td><input type="number" name="userId" id="userId" required
                           value="${para.userId==null?cookie.userid.value:para.userId}" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" required />
                    <input type="hidden" name="destination" value="${param.destination}"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value ="Login >>"/></td>
            </tr>
            <tr><td colspan="2"><b><font color="red">${message}</font></b></td></tr>
        </table>
    </form>
    </body>
</html>
