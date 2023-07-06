<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-23(023)
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TourList</title>
</head>
<body>
<h2>관광 리스트</h2>
<c:forEach items="${tourList}" var="tourList">
    <img style="width: 20px; height: 20px; object-fit: cover" src="${tourList.value.thumbnailImage}"/>
    ${tourList.value.title}
</c:forEach>
</body>
</html>
