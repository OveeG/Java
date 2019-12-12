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

	<form:form action="http://localhost:8080/HibernateSpring/state/add"
		method="POST" modelAttribute="state"> 
			<table align="center">
            <tr>
               <td><form:label path="st_id">State Id</form:label></td>
               <td><form:input path="st_id" /></td>
            </tr>
            <tr>
               <td><form:label path="st_name">State Name</form:label></td>
               <td><form:input path="st_name" /></td>
            </tr>
            <tr>
               <td><form:label path="st_code">State Code</form:label></td>
               <td><form:input path="st_code" /></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                  <input type="submit" value="Submit"/>
               </td>
            </tr>
         </table>  
	</form:form>

<hr>
	<table width="2" align="center">
		<tr>
			<th colspan="3">State Id</th>
			<th colspan="3">State Name</th>
			<th colspan="3">State Code</th>
			<th colspan="3">Action</th>

		</tr>

		<c:forEach items="${states}" var="state">
			<tr>
				<td colspan="3"><c:out value="${state.st_id}"></c:out></td>
				<td colspan="3"><c:out value="${state.st_name}"></c:out></td>
				<td colspan="3"><c:out value="${state.st_code}"></c:out></td>
				<td colspan="3"><a href="http://localhost:8080/HibernateSpring/employee/update/${emp.emp_id}">Edit</a>
				     <a href="http://localhost:8080/HibernateSpring/employee/delete${emp.emp_id}">Delete</a>
				 </td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>