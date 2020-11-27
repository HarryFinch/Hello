<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 2020/7/17
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/springDemo4/testRedirect">Test Redirect</a>
<br><br>
<a href="${pageContext.request.contextPath}/springDemo4/testView">Test View</a>
<br><br>

<!-- ViewAndViewResolver -->
<a href="${pageContext.request.contextPath}/springDemo4/testViewAndViewResolver">Test ViewAndViewResolver</a>
<br><br>


<!--
模拟修改操作
1、原始数据：id:1,    name:Harold     pwd:123     email:123@345       age;12
2、密码不能修改
3、表单回显，模拟操作直接在表单填写对应的属性值
-->
<form action="${pageContext.request.contextPath}/springMVCDemo3/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">

    <label for="userName">用户名</label>
    <input type="text" name="userName" id="userName" value="Harold"><br>

<%--    <label for="password">密码</label>--%>
<%--    <input type="password" name="password" id="password" value="123"><br>--%>

    <label for="email">邮箱</label>
    <input type="text" name="email" id="email" value="123@345"><br>

    <label for="age">年龄</label>
    <input type="text" name="age" id="age" value="20"><br>


    <input type="submit" value="submit">
</form>
<br><br>

<!-- SessionAttributes注解 -->
<a href="${pageContext.request.contextPath}/springDemo3/testSessionAttribute">Test SessionAttributes</a>
<br><br>
<!-- 数据处理的另一种方式，目标方法参数为Map -->
<a href="${pageContext.request.contextPath}/springDemo3/testMap">Test Map</a>
<br><br>

<!-- ModelAndView处理数据模型 -->
<a href="${pageContext.request.contextPath}/springDemo3/testModelAndView">Test ModelAndView</a>
<br><br>

<!-- SpringMVC中的Servlet原生API -->
<a href="${pageContext.request.contextPath}/springDemo2/testServletAPI">Test ServletAPI</a>
<br><br>

<!-- SpringMVC POJO -->
<form action="${pageContext.request.contextPath}/springDemo2/testPojo">
   <%-- <label for="userName">用户名</label>
    <input type="text" name="userName" id="userName"><br>

    <label for="password">密码</label>
    <input type="password" name="password" id="password"><br>

    <label for="email">邮箱</label>
    <input type="text" name="email" id="email"><br>

    <label for="age">年龄</label>
    <input type="text" name="age" id="age"><br>--%>

    <label for="address.province">省份</label>
    <input type="text" name="address.province" id="address.province"><br>

    <label for="address.city">省份</label>
    <input type="text" name="address.city" id="address.city"><br>

    <label for="address.county">县/区</label>
    <input type="text" name="address.county" id="address.county"><br>

    <input type="submit" value="submit">
</form>
<br><br>

<!-- @CookieValue注解 -->
<a href="${pageContext.request.contextPath}/springDemo2/testCookieValue">Test CookieValue</a>
<br><br>

<!-- @RequestHeaders注解 -->
<a href="${pageContext.request.contextPath}/springDemo2/testRequestHeader">Test RequestHeader</a>
<br><br>

<!-- @RequestParam注解 -->
<a href="${pageContext.request.contextPath}/springDemo2/testRequestParam?userName=Harold&age=12">Test RequestParam</a>
<br><br>





<!--
REST风格的post请求和get请求
HiddenHttpMethodFilter过滤器将delete、put请求转换为post请求
-->
<a href="${pageContext.request.contextPath}/springMVC/testRestGet/1">Test REST Get</a>
<br><br>

<form action="${pageContext.request.contextPath}/springMVC/testRestPost" method="post">
    <input type="submit" value="TestRestValue POST">
</form>
<br><br>

<form action="${pageContext.request.contextPath}/springMVC/testRestDelete/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="TestRestValue DELETE">
</form>
<br><br>

<form action="${pageContext.request.contextPath}/springMVC/testRestPut/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="TestRestValue PUT">
</form>
<br><br>

<!-- pathVariable注解 -->
<a href="${pageContext.request.contextPath}/springMVC/testPathVariable/1">Test PathVariable</a>
<br><br>

<!-- Ant路径 -->
<a href="${pageContext.request.contextPath}/springMVC/testAnt/a/any">Test Ant</a>
<br><br>

<!-- params注解 -->
<a href="${pageContext.request.contextPath}/springMVC/testParams?userName=Harold&age=11">Test Params</a>
<br><br>

<!-- @RequestMapping注解的method属性 -->
<form action="${pageContext.request.contextPath}/springMVC/testMethod" method="post">
    <input type="submit" value="submit">
</form>
<br><br>


<!-- @RequestMapping第一个示例 -->
<a href="${pageContext.request.contextPath}/springMVC/testRequestMapping">SpringMVC</a>
<br/><br/>

<a href="${pageContext.request.contextPath}/springmvc/helloWorld">Hello World</a>
</body>
</html>
