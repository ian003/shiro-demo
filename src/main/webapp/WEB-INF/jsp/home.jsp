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
			<div style="float: left">Apache Shiro Sample App - Home</div>
			<div class="info">
				Logged in as ${currentUser.username} (<a
					href="<c:url value="/logout.do"/>">Logout</a>)
			</div>
		</div>


		<div class="content">

			<p>Users in the system:</p>
			<ul>
				<c:forEach var="user" items="${users}">
					<li>${user.username} - ${user.password}</li>
				</c:forEach>
			</ul>

			<p>
				<shiro:hasPermission name="user:manage">
            Since you are logged in as the admin user, you can <a
						href="<c:url value="/manageUser.do"/>">manage site users</a>.
        </shiro:hasPermission>
				<shiro:lacksPermission name="user:manage">
            Since you are not logged in as the admin user, you can't manage site users.
        </shiro:lacksPermission>
			</p>
		</div>
	</div>
</body>
</html>