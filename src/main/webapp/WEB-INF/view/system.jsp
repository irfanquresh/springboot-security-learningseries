
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h1>Admin Page</h1>
	<hr>
	<p>Welcome to Admin page</p>
	<hr>

	<p>Home sections</p>
	<p>
		<a href="${pageContext.request.contextPath}/">Home Page</a>
	</p>
</body>
</html>