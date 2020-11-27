<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 2020/7/17
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome!!!</h1>

<div>
    time:${requestScope.time}
</div>

<div>
    name:${requestScope.name}
</div>

<div>
    RequestUser:${requestScope.user}
</div>

<div>
    SessionUser:${sessionScope.user}
</div>

<div>
    <fmt:message key="i18n.username"></fmt:message>
    <fmt:message key="i18n.password"></fmt:message>
</div>
</body>
</html>
