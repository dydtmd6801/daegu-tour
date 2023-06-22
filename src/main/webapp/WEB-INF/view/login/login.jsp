<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-15(015)
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form:form modelAttribute="loginDto">
    <p>아이디 : <form:input path="userId"/></p>
    <p>비밀번호 : <form:password path="userPassword" autocomplete="false"/></p>
    <input type="submit" value="로그인">
</form:form>
<a href="/regist">[회원가입]</a>
</body>
</html>
