<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-16(016)
  Time: 오후 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>step3</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<p>아이디 : ${registDto.userId}</p>
<p>이름 : ${registDto.name}</p>
<p>전화번호 : ${registDto.phoneNumber}</p>
</body>
</html>
