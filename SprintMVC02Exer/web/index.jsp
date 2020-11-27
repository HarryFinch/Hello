<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 2020/7/21
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#testJson").click(function () {
                var url = this.href;
                var args = {};
                $.post(url, args, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var id = data[i].id;
                        var lastName = data[i].lastName;

                        alert(id + " , " + lastName);
                    }
                });
                return false;
            });
        })
    </script>
</head>
<body>

<a href="emps">List All Employees</a>
<br><br>

<a href="${pageContext.request.contextPath}/springMVCDemo1/testJson" id="testJson">Test Json</a>
<br><br>

<!-- 文件上传-->
<form action="${pageContext.request.contextPath}/springMVCDemo1/testHttpMessageConverter" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file"/>
    Desc:<input type="text" name="desc"/>
    <input type="submit" value="submit"/>
</form>
<br><br>

<a href="${pageContext.request.contextPath}/springMVCDemo1/testResponseEntity">Test File Download</a>
<br><br>

<!--
关于国际化
    1、在页面上能够根据浏览器语言设置的情况，对文本、时间、数值进行本地化处理
    2、可以在 bean 中获取国际化资源文件 Locale 对应的消息
    3、可以通过超链接切换 Locale, 而不再依赖于浏览器语言设置情况
解决方法
    1、使用 JSTL 的 fmt 标签
    2、在 bean 中注入 ResourceBundleMessageSource 的示例，使用对应的getMessage 方法即可
    3、配置 LocaleResolver 和 LocaleChangeInterCeptor
 -->
<a href="i18n">I18N Page</a>
<br><br>
<a href="i18n1">I18N1 Page</a>
<br><br>

<!-- 文件上传 -->
<form action="${pageContext.request.contextPath}/springMVCDemo1/testMultipartFileUpload" method="post" enctype="multipart/form-data">
    File<input type="file" name="file"/>
    Desc<input type="text" name="desc"/>
    <input type="submit" value="submit"/>
</form>
<br><br>

<!-- 异常处理之ExceptionHandler -->
<a href="${pageContext.request.contextPath}/springDemo1/testExceptionHandlerExceptionResolver?i=19" >Test ExceptionHandlerExceptionResolver</a>
<br><br>

<!-- 异常处理之 ResponseStatusExceptionResolver -->
<a href="${pageContext.request.contextPath}/springDemo1/testResponseStatusExceptionResolver">Test ResponseStatusExceptionResolver</a>
<br><br>

<!-- 异常处理之 ResponseStatusExceptionResolver -->
<a href="${pageContext.request.contextPath}/springDemo1/testResponseStatusExceptionResolver">Test DefaultHandlerExceptionResolver</a>
<br><br>

<!-- 异常处理之 SimpleMappingExceptionResolver -->
<a href="${pageContext.request.contextPath}/springDemo1/testSimpleMappingExceptionResolver?i=2">Test DefaultHandlerExceptionResolver</a>
<br><br>




</body>
</html>














