<%-- 
    Document   : ShowCustomer
    Created on : Oct 14, 2014, 1:30:08 PM
    Author     : INT303
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag  body-content="scriptless" %>
<%@attribute name="listOfCustomer" required="true" rtexprvalue="true" type="java.util.List" %>
<%@attribute name="headerFlagment" fragment="true" %>
<table>
     <jsp:invoke fragment="headerFlagment"/>
    <c:set var="count" value="1" scope="page" />
    <c:forEach items="${listOfCustomer}" var="c">
        <tr bgcolor="${count%2==0 ? 'wheat' : 'tan'}">
            <td>${count}</td>
            <td align="right">${c.customerId} &nbsp; &nbsp; &nbsp; &nbsp; </td>
            <td><a href=SearchCustomer?id=${c.customerId}>${c.name}</a></td>
            <td>${c.addressLine1}</td>
            <td>${c.addressLine2}</td>
            <td>${c.city}</td>
            <td>${c.state}</td>
            <td>${c.phone}</td>
            <td>${c.zip}</td>
            <td>${c.email}</td>
            <td>${c.creditLimit}</td>
            <td align="center">${c.discountCode}</td>
        </tr>
        <c:set var="count" value="${count+1}" scope="page" />
    </c:forEach>
        <tr><td colspan="11"><font style="font-size: 8pt"> produce by tag file: ShowCustomer</font></td></tr>
</table>
