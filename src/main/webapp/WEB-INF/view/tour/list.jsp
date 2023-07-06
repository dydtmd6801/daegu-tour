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
    <link rel="stylesheet" href="../../../static/css/font.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>관광 리스트</h2>
<div class="d-flex flex-wrap justify-content-center" style="margin: 0 5%">
    <c:forEach items="${tourList}" var="tourList">
        <div class="card" style="width: 23%; margin: 1%;">
            <img src="${tourList.value.thumbnailImage}" class="card-img-top" alt="..."/>
            <div class="card-body">
                <h5 class="card-title">${tourList.value.title}</h5>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
