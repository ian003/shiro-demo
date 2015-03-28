<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Apache Shiro Sample Application</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/sample.css"/>"/>
</head>
<body>
    <div id="box">
        <div class="title">Apache Shiro Sample App - Signup</div>

        <div class="content">
            <form:form modelAttribute="signupCommand">

                <form:errors path="*" element="div" cssClass="errors"/>

                <div><div class="form-label">Username:</div><form:input path="username"/></div>
                <div><div class="form-label">Password:</div><form:password path="password"/></div>
                <div><input type="button" onclick="document.location.href='<c:url value="/login.do"/>'" value="Cancel"/>&nbsp;<input type="submit" value="Signup"/></div>
            </form:form>
        </div>
    </div>

    <script type="text/javascript">
        document.getElementById('username').focus();
    </script>

</body>
</html>