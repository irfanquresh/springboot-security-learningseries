
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Hi There</h1>


	<form:form id="command" class="form-signin"
		action="${pageContext.request.contextPath}/logout" method="POST">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Logout</button>
	</form:form>
</body>
</html>