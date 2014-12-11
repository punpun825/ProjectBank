<%-- 
    Document   : CustomerEntryForm
    Created on : Nov 12, 2014, 2:14:33 PM
    Author     : pichet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sit.int303.spe.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Entry Form</title>
    </head>
    <body onload="document.getElementById('name').focus()">
        <f:PageHeader title=" :: Customer Entry Form ::"/>
        <form action="UpdateCustomer" method="post">
            <f:CustomerForm customer="${customer}" isReadOnly="false"/>
        </form>
        <div align="center" style="background: lightsalmon">
            <p>${message}</p>
        </div>
    </body>
</html>
