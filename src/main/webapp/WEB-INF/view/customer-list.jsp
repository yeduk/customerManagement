<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/table.css">
<meta charset="ISO-8859-1">
<title>List of all customers</title>
</head>
<body>

	<header class="user__header">
		
		
	<form action="searchCustomer" class="form">
		<input type="text" name="val" class="form__input" placeholder="Enter customer name or id">
		<input type="submit" class="btn" value="search">
	</form>
	<button onclick="location.href='regForm'" class="btn">New Customer</button>
	<button class="btn" onclick="location.href='custList'">List
		Customers</button>
			<h1 class="user__title">Customer List</h1>
			<br>
			<br>
			<br>
			<br>
	</header>
	<table>


		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date of birth</th>
			<th>Gender</th>
			<th>Email-ID</th>
			<th>Phone No</th>
			<th>Action</th>
		</tr>

		<c:forEach var="c" items="${customers}">

			<tr>
				<td>${c.id}</td>
				<td>${c.firstName}</td>
				<td>${c.lastName}</td>
				<td>${c.dob}</td>
				<td>${c.gender}</td>
				<td>${c.email}</td>
				<td>${c.phn}</td>
				<td><a href="deleteCustomer?id=${c.id}"
					onclick="if(!confirm('are you sure??'))return false"> DELETE </a> | <a
					href="updateCustomer?id=${c.id}"> UPDATE </a></td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>