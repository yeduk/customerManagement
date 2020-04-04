<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/form.css">




<title>Customer Form</title>
</head>
<body>

	<div class="user">
		

		<form:form action="regCustomer" method="post"
			modelAttribute="customer" class="form">

			<form:hidden path="id" />

			<div class="form__group">
				<div class="form__text">Customer's First Name</div>
				<form:input path="firstName" class="form__input"
					placeholder="First Name" />
				<form:errors path="firstName" cssClass="error" />
			</div>

			<div class="form__group">
				<div class="form__text">Customer's Last Name</div>
				<form:input path="lastName" placeholder="Last Name"
					class="form__input" />
				<form:errors path="lastName" cssClass="error" />

			</div>

			<div class="form__group">
				<div class="form__text">Date of Birth </div>
				<form:input type="date" class="form__input" path="dob"
					placeholder="DOB : yyyy-MM-dd" />
				<form:errors path="dob" cssClass="error" />
			</div>


			<div class="form__group">
			<div class="form__text" >Gender</div>
				<form:input name="gender" path="gender" placeholder="Male/Female"
					class="form__input" />
				<form:errors path="gender" cssClass="error" />

			</div>

			<div class="form__group">
			<div class="form__text" >Email-ID</div>
				<form:input type="email" path="email" placeholder="Email"
					class="form__input" />
				<form:errors path="email" cssClass="error" />

			</div>

			<div class="form__group">
			<div class="form__text" >Contact No</div>
				<form:input path="phn" placeholder="Phone Number"
					class="form__input" />
				<form:errors path="phn" cssClass="error" />
			</div>


			<input type="submit" value="Register" class="btn" />
			<input type="reset" onclick="location.href='regForm'" value="Reset"
				class="btn" />
			<button  type="button" class="btn" onclick="location.href='custList'">List
				Customers</button>
		</form:form>


		<br>

		<h4 class="toast">${msg}</h4>

	</div>
</body>
</html>