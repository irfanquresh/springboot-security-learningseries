
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Please sign in - Custom</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	rel="stylesheet" />

<style>
.failed {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<form:form id="command" class="form-signin"
			action="${pageContext.request.contextPath}/authenticateTheUser"
			method="POST">
			<h2 class="form-signin-heading">Please sign in</h2>


			<c:if test="${param.error != null}">
				<div class="alert alert-warning" role="alert">Sorry! You
					entered invalid username/password.</div>
			</c:if>
			
			<c:if test="${param.logout != null}">
				<div class="alert alert-success" role="alert">You have been logged-out!!!</div>
			</c:if>
			

			<p>
				<label for="username" class="sr-only">Username</label> <input
					type="text" id="username" name="username" class="form-control"
					placeholder="Username" required autofocus>
			</p>
			<p>
				<label for="password" class="sr-only">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Password" required>
			</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign-in</button>
		</form:form>
	</div>
</body>
</html>