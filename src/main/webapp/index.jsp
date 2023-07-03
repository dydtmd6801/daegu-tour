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
    <link rel="stylesheet" href="static/css/imageSlider.css">
    <link rel="stylesheet" href="static/css/navBar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script defer src="/static/js/imageSlider.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="/index">대구의 눈과 입</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/tour">관광지</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">음식점</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <c:if test="${empty AuthInfo}">
                    <a class="nav-link" href="/login">로그인</a>
                    <a class="nav-link" href="/login">회원가입</a>
                </c:if>
                <c:if test="${!empty AuthInfo}">
                    <p>${AuthInfo.userName}님, 환영합니다.</p>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
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
