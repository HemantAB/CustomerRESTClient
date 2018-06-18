<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Clients</title>
</head>
<body>
<h1>Manage Clients</h1>
<table>
<thead>Add Cusomter</thead>
<tr>
<form name="addCustomer" action="addCustomer">
<td>
First Name
</td>
<td>
<input type="text" name=firstName">
</td>
<td>
Surname
</td>
<td>
<input type="text" name=surName">
</td>
<td><input type="submit"> 
</td>
<td><%session.getAttribute("CustListJson");%>
</td>
</tr>
</form>

</table>
</body>
</html>