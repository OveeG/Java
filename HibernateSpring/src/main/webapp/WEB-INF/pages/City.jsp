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

	<form:form action="http://localhost:8080/HibernateSpring/city/addcity"
		method="POST" modelAttribute="city">
		<table align="center">
			<tr>
				<td><form:label path="c_id">City Id</form:label></td>
				<td><form:input path="c_id" /></td>
			</tr>
			<tr>
				<td><form:label path="c_name">City Name</form:label></td>
				<td><form:input path="c_name" /></td>
			</tr>
			<tr>
				<td><form:label path="c_pincode">City PinCode</form:label></td>
				<td><form:input path="c_pincode" /></td>
			</tr>
			<tr>
				<form:label path="state">SelectState :</form:label>
				<td><form:select path="state" multiple="false">
						<c:forEach items="${states}" var="st">
							<form:option path="state" value="${st.st_id }">
								<c:out value="${st.st_code}"></c:out>
								<c:out value="${st.st_name}"></c:out>
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<hr>
	<table width="2" align="center">
		<tr>
			<th colspan="3">City Id</th>
			<th colspan="3">City Name</th>
			<th colspan="3">City Code</th>
			
			<th colspan="3">Action</th>

		</tr>

		<c:forEach items="${cities}" var="City">
			<tr>
				<td colspan="3"><c:out value="${City.c_id}"></c:out></td>
				<td colspan="3"><c:out value="${City.c_name}"></c:out></td>
				<td colspan="3"><c:out value="${City.c_pincode}"></c:out></td>
				<td colspan="3"><c:out value="${City.state}"></c:out></td>
				<td colspan="3"><a
					href="http://localhost:8080/HibernateSpring/employee/update/${emp.emp_id}">Edit</a>
					<a
					href="http://localhost:8080/HibernateSpring/employee/delete${emp.emp_id}">Delete</a>
				</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>