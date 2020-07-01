
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied Page</title>
</head>
<body>
	<h1>No Authorization!!!</h1>
	<hr>
	<p>Access Denied - You are not authorized to access this page!!!</p>
	<hr>

	<p>
		<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	</p>
</body>
</html>