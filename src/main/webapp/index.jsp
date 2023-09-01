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
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/css/navBar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="/static/js/imageSlider.js"></script>
    <script defer src="/static/js/navBarOpacity.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg">
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
                    <span class="nav-link fs-6"><strong>${AuthInfo.userName}님</strong>, 환영합니다!</span>
                    <button class="nav-link fs-6" id="logout">로그아웃</button>
                    <script>
                        const logoutBtn = document.querySelector("#logout");

                        logoutBtn.addEventListener("click", () => {
                            $.ajax({
                                url: "/logout",
                                type: "get",
                                success: () => {
                                    window.alert("로그아웃 되었습니다.");
                                    window.location.href="/index";
                                },
                            })
                        })
                    </script>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div style="position: absolute; right: 8%; bottom: 20%; z-index: 5;" class="d-flex flex-column align-items-end">
    <h1 class="display-2 text-white fw-bold">대구 관광의</h1>
    <h1 class="display-2 text-white fw-bold">모든 것</h1>
</div>
<div id="slider">
    <ul class="slides">
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2018/09/02/07/07/south-korea-3648252_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2019/12/17/01/37/korea-4700537_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2018/11/26/02/00/korea-3838656_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://live.staticflickr.com/5493/11726526334_fc8a4fbfe3_b.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2020/02/27/15/00/city-4884924_1280.jpg">
        </li>
        <li class="slide">
            <img src="https://cdn.pixabay.com/photo/2018/09/02/07/07/south-korea-3648252_1280.jpg">
        </li>
    </ul>
</div>
</body>
</html>
