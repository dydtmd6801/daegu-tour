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
    <script defer src="../../../static/js/checkValidation.js"></script>
    <script defer src="../../../static/js/setLoginFormDesign.js"></script>
    <style>
        .errors {
            display: block;
        }
    </style>
</head>
<body>
<div class="m-auto mt-5 w-25 d-flex flex-column align-items-center">
    <h1 class="display-5 mb-5">로그인</h1>
    <form:form modelAttribute="loginDto" class="needs-validation m-auto w-100 d-flex flex-column align-items-center" novalidate="true">
        <div class="form-floating mt-3 mb-1 w-100">
            <form:input path="userId" class="form-control" id="floatingInput" placeholder="아이디" required="false"/>
            <label for="floatingInput">아이디</label>
            <div class="invalid-feedback">
                아이디를 입력해주세요.
            </div>
            <form:errors class="invalid-feedback errors" path="userId"/>
        </div>
        <div class="form-floating mb-2 w-100">
            <form:password path="userPassword" class="form-control" id="floatingPassword" placeholder="비밀번호" required="false" />
            <label for="floatingPassword">비밀번호</label>
            <div class="invalid-feedback">
                비밀번호를 입력해주세요.
            </div>
            <form:errors class="invalid-feedback errors" path="userPassword"/>
        </div>
        <input type="submit" class="btn btn-outline-secondary w-100 loginBtn" value="로그인">
    </form:form>
    <p class="mt-3">회원이 아니신가요? <a class="btn-link" href="/regist">회원가입</a></p>
</div>
</body>
</html>
