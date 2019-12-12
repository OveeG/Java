<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Information</title>
</head>
<body>

	<form:form action="http://localhost:8080/HibernateSpring/employee/save"
		method="POST" modelAttribute="empbn" > 
			EmpId : <form:input path="emp_id" value="${empbn.emp_id }" />
		<br>
		<br>
			EmpName : <form:input path="emp_name" value="${empbn.emp_name }" />
		<br>
		<br>

		<input type="submit">
	</form:form>


	<table>
		<tr>
			<th>EmpId</th>
			<th>EmpName</th>
			<th>Action</th>

		</tr>

		<c:forEach items="${employees}" var="emp">
			<tr>
				<td><c:out value="${emp.emp_id}"></c:out></td>
				<td><c:out value="${emp.emp_name}"></c:out></td>
				<td><a href="http://localhost:8080/HibernateSpring/employee/update/${emp.emp_id}">Edit</a>
				     <a href="http://localhost:8080/HibernateSpring/employee/delete${emp.emp_id}">Delete</a>
				 </td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>