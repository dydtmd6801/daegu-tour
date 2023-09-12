<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-07-06(006)
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <link rel="stylesheet" href="../../static/css/font.css">
    <link rel="stylesheet" href="../../static/css/navBar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../../static/js/logOut.js"></script>
    <script defer src="../../static/js/changeUserInfo.js"></script>
    <style>
        .navbar{
            background-color: #fff;
            position: static !important;
        }
        .userMenu {
            display: none;
            font-size: 0.75rem;
            width: 149px;
            top: 35px;
            left: 50%;
            transform: translate(-50%, 0);
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg border-bottom border-secondary">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold fs-4" href="/index">대구 관광</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link fs-6" href="/tour">관광지</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-6" href="/board?page=1">공지사항</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <c:if test="${empty AuthInfo}">
                    <a class="nav-link fs-6" href="/login">로그인</a>
                    <a class="nav-link fs-6" href="/regist">회원가입</a>
                </c:if>
                <c:if test="${!empty AuthInfo}">
                    <span class="nav-link fs-6 userName" style="position: relative"><strong>${AuthInfo.userName}</strong>
                    <a class="userMenu nav-link text-center text-bg-secondary position-absolute rounded" href="/changeInfo">
                        개인정보수정
                    </a></span>
                    <button class="nav-link fs-6" id="logout">로그아웃</button>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
