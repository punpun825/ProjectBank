<%-- 
    Document   : CustomerForm
    Created on : Nov 11, 2014, 2:05:52 PM
    Author     : INT303
--%>

<%@tag description="Customer Entry Form" pageEncoding="UTF-8"%>
<%@tag body-content="empty"%>
<%@attribute name="isReadOnly" required="true"%>
<%@attribute name="customer" required="true" rtexprvalue="true" type="sit.int303.spe.model.Customer" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set  var="editable" value="${isReadOnly=='false' || isReadOnly=='no' ? '' : 'readonly'}"/>
<div align="center">
    <div align="center" style="border: navy inset 1px ;width: 90%;background-color: #ccccff;margin: 30pt">    
        <table style="line-height: 30pt;margin-top: 10pt;margin-bottom: 30pt">
            <tr><th colspan="5" style="line-height: 50pt">
                    <h3>${customer==null?'Create New Customer':'Update Customer Info.'}</h3></th></tr>
            <tr>
                <td style="text-align: right">Customer Id : </td>
                <td><input type="text" readonly name="customerId" 
                           value="${customer==null?'Auto Number':customer.customerId}" 
                           style="text-align: center; width: 80px;background-color: lightgoldenrodyellow;font-stretch: expanded "/></td>
                <td>&nbsp;</td>
                <td style="text-align: right">Name : </td>
                <td><input ${editable} type="text" name="name" value="${customer.name}" style="width: 250px" id="name"/></td>
            </tr>
            <tr>
                <td style="text-align: right">Address Line 1: </td>
                <td colspan="4"><textarea  ${editable} name="addressLine1"  style="width: 98%" required/>${customer.addressLine1}</textarea>
            </tr>
            <tr>
                <td style="text-align: right">Address Line 2: </td>
                <td colspan="4"><textarea  ${editable} name="addressLine2" style="width: 98%" required/>${customer.addressLine2}</textarea>
            </tr>
            <tr>
                <td style="text-align: right">City : </td>
                <td><input  ${editable} type="text" name="city" value="${customer.city}" required/></td>
                <td>&nbsp;</td>
                <td style="text-align: right">State : </td>
                <td>
                    <input  ${editable} type="text" name="state" value="${customer.state}" required style="width: 30pt"/>&nbsp;&nbsp;&nbsp;
                    Zip: <input type="text" name="zip" value="${customer.zip}" required style="width: 50pt"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right">Phone: </td>
                <td><input ${editable}  type="text" name="phone" value="${customer.phone}" required/></td>
                <td>&nbsp;</td>
                <td style="text-align: right">email Address: </td>
                <td><input  ${editable} type="text" name="email" value="${customer.email}" required/></td>
            </tr>
            <tr>
                <td style="text-align: right">Credit Limit: </td>
                <td><input ${editable}  type="text" name="creditLimit" value="${customer.creditLimit}" required/></td>
                <td>&nbsp;</td>
                <td style="text-align: right">Discount Code (H/L/M/N): </td>
                <td ><input  ${editable} type="text" name="discountCode" value="${customer.discountCode}" required 
                            style="width: 30pt;text-align: center"/></td>
            </tr>
            <c:if test="${isReadOnly=='false' || isReadOnly=='no'}">
                <tr>
                    <td colspan="5" align="right">
                        <input type="button" value=" Cancel" style="background-color: coral" onclick="history.go(-1)"/>&nbsp;&nbsp;&nbsp;
                        <input type="submit" value="<< Save >>" style="background-color: cadetblue"/>
                    </td>
                    <td>
                        
                    </td>
                </tr>
            </c:if>

        </table>
    </div>
</div>