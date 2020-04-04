<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/form.css">
<meta charset="ISO-8859-1">
<style>
.error {
	color: red;
}
</style>
<title>Manager Login</title>
</head>
<body>

	<div class="user">
		<header class="user__header">
			<h1 class="user__title">Manager Login</h1>
		</header>
		<form action="validManager" method="post" class="form">

			<div class="form__group">
				<input placeholder="Manager ID" name="id" class="form__input" />
			</div>

			<div class="form__group">
				<input type="password" name="pwd" placeholder="Password"
					class="form__input" />
			</div>
			<input type="submit" value="login" class="btn" />

		</form>
		${msg}
	</div>
</body>
</html>