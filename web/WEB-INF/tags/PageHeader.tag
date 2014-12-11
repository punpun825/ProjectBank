<%-- 
    Document   : PageHeader
    Created on : Oct 24, 2014, 10:53:07 AM
    Author     : INT303
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title"%>

<c:set var="bg" value="border-bottom: teal thin solid"/>
<table width="99%">
    <tr style="background-color: #2aabd2"><td width="70%" style="${bg}"><h3>${title==null?'No Tile' : title}</h3></td>
        <td width="30%" style="${bg}" align="right">
            <c:choose>
                <c:when test="${user==null}">
                    Hello <a href="Login" title="Login to CO System">Guest</a>  &nbsp;
                </c:when>
                <c:otherwise>
                    Hello <a href="Logout" title="Logout from CO System">${user.name}</a>  &nbsp;
                </c:otherwise>
            </c:choose>
            
         </td>
    </tr>
</table>
