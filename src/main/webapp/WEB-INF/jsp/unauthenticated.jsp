<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Apache Shiro Sample Application</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/styles/sample.css"/>" />
</head>
<body>
	<h3>Unauthorized</h3>
	<p>
		认证未通过。 <a href="<c:url value="/home.do"/>">homepage</a>.
	</p>
</body>
</html>
