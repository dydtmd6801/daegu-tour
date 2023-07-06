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
    <link rel="stylesheet" href="static/css/imageSlider.css">
    <script defer src="/static/js/imageSlider.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"/>
<div id="slider">
    <ul class="slides">
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2018/11/19/15/06/machang-bridge-3825439_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2020/06/11/11/52/korean-folk-village-5286449_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2017/01/03/20/25/the-landscape-1950544_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2018/08/23/03/26/south-korea-3625168_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2020/02/27/15/00/city-4884924_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2018/11/19/15/06/machang-bridge-3825439_1280.jpg">
        </li>
    </ul>
</div>
</body>
</html>
