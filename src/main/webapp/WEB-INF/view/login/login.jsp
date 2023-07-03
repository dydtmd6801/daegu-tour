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
    <link rel="stylesheet" href="static/css/font.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div class="m-auto mt-5 w-50 d-flex flex-column align-items-center">
    <h1 class="display-5 mb-5">로그인</h1>
    <form:form modelAttribute="loginDto" class="m-auto w-100 d-flex flex-column align-items-center">
        <div class="form-floating mt-3 mb-1 w-50">
            <form:input path="userId" class="form-control" id="floatingInput" placeholder="아이디"/>
            <label for="floatingInput">아이디</label>
            <p><form:errors class="invalid-feedback" path="userId"/></p>
        </div>
        <div class="form-floating mb-2 w-50">
            <form:password path="userPassword" class="form-control" id="floatingPassword" placeholder="비밀번호"/>
            <label for="floatingPassword">비밀번호</label>
            <p><form:errors class="invalid-feedback" path="userPassword"/></p>
        </div>
        <input type="submit" class="btn btn-outline-secondary w-50" value="로그인">
        <script>
            const loginBtn = document.querySelector(".btn");
            const inputHeight = document.querySelector(".form-control").clientHeight;

            loginBtn.style.height = inputHeight + "px";
        </script>
    </form:form>
    <p class="mt-3">회원이 아니신가요? <a class="btn-link" href="/regist">회원가입</a></p>
</div>
</body>
</html>
