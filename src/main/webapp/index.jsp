<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-14(014)
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인화면</title>
    <link rel="stylesheet" href="static/css/font.css">
</head>
<body>
<h2>메인화면</h2>
<c:if test="${empty AuthInfo}" >
    <a href="/login">로그인</a>
</c:if>
<c:if test="${!empty AuthInfo}">
    <p>환영합니다. ${AuthInfo.userName}님</p>
</c:if>
<a href="/tour">[관광 리스트]</a>
</body>
</html>
