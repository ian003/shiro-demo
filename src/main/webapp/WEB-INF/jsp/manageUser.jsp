<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<html>
<head>
<title>Apache Shiro Spring-Hibernate Sample Application</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/styles/sample.css"/>" />
</head>
<body>

	<div id="bigbox">
		<div class="title clearfix">
			<div style="float: left">Apache Shiro Sample App - Manage Users</div>
			<div class="info">
				Logged in as ${currentUser.username} (<a
					href="<c:url value="/logout.do"/>">Logout</a>)
			</div>
		</div>


		<div class="content">

			<table id="manageUsers">
				<tr>
					<th>Username</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.username}</td>
						<td><a href="<c:url value="/editUser.do?userId=${user.id}"/>">Edit</a>
							<c:if test="${user.id ne 1}">&nbsp;|&nbsp;<a
									href="<c:url value="/deleteUser.do?userId=${user.id}"/>">Delete</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>

			<p>
				Return to <a href="<c:url value="/home.do"/>">Home</a>
			</p>
		</div>

	</div>

</body>
</html>
