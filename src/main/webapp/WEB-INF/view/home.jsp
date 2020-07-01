
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Home Page</h1>
	<hr>
	<p>Welcome to Home page</p>
	<hr>
	<p>
		User:
		<security:authentication property="principal.username" />
	</p>
	<p>
		Role:
		<security:authentication property="principal.authorities" />
	</p>
	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<p>Leader sections</p>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leaders</a>
		</p>
		<hr>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>Admin sections</p>
		<p>
			<a href="${pageContext.request.contextPath}/system">System</a>
		</p>
		<hr>
	</security:authorize>

	<form:form id="command" class="form-signin"
		action="${pageContext.request.contextPath}/logout" method="POST">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Logout</button>
	</form:form>
</body>
</html>