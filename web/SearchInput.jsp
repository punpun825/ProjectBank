<form action="SearchCustomer" method="post">
    <table width="99%">
        <tr style="background-color: bisque">
            <td>Enter Customer name/id : </td>
            <td><input type="text" required name="id" size="20" value="${param.id}"
                       style="background-color: lightyellow;border: antiquewhite solid thin"></td>
            <td><input type="submit" value="Search"
                       style="border: thin bisque ridge;background-color: azure"></td>
            <td width="70%" align="right"><a href="index.jsp">:: Home ::</a></td>
        </tr>
    </table>
</form>