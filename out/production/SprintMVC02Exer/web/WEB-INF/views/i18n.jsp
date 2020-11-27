<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 2020/7/21
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:message key="i18n.user"></fmt:message>
<br><br>

<a href="/views/i18n1">I18N1 Page</a>
<br><br>

<!-- 通过超链接切换Locale-->
<a href="/views/i18n1?locale=zh_CH">中文</a>
<br><br>

<a href="/views/i18n1?locale=en_US">英文</a>
<br><br>



</body>
</html>
