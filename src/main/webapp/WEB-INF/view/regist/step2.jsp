<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-16(016)
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>step2</title>
    <link rel="stylesheet" href="../../../static/css/font.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../../../static/js/checkDuplicationJS.js"></script>
    <script defer src="../../../static/js/checkValidation.js"></script>
    <script defer src="../../../static/js/setRegistFormDesign.js"></script>
    <style>
        .errors{
            display: block !important;
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="m-auto mt-5 w-25 d-flex flex-column align-items-center">
    <h1 class="display-5 mb-5">회원가입</h1>
    <form:form action="step3" class="needs-validation w-100" method="post" modelAttribute="registDto" novalidate="false">
        <div class="input-group mb-2 w-100">
            <div class="form-floating">
                <form:input path="userId" class="form-control" id="userId" required="false" placeholder="아이디"/>
                <label for="userId">아이디</label>
                <div class="invalid-feedback">
                    아이디를 입력해주세요.
                </div>
            </div>
            <button class="btn btn-outline-secondary" type="button" id="checkBtn">중복체크</button>
        </div>
        <div id="result" class="invalid-feedback errors mb-2"></div>
        <form:errors class="invalid-feedback errors mb-2" path="userId"/>

        <div class="form-floating mb-2 w-100">
            <form:password path="password" class="form-control" id="floatingPassword" placeholder="비밀번호" required="false" />
            <label for="floatingPassword">비밀번호</label>
            <div class="invalid-feedback">
                비밀번호를 입력해주세요.
            </div>
            <form:errors class="invalid-feedback errors" path="password"/>
        </div>

        <div class="form-floating mb-2 w-100">
            <form:password path="confirmPassword" class="form-control" id="floatingConfirmPassword" placeholder="비밀번호 확인" required="false" />
            <label for="floatingConfirmPassword">비밀번호 확인</label>
            <div class="invalid-feedback">
                비밀번호 확인을 입력해주세요.
            </div>
            <form:errors class="invalid-feedback errors" path="confirmPassword"/>
        </div>

        <div class="form-floating mb-2 w-100">
            <form:input path="name" class="form-control" id="floatingName" placeholder="이름" required="false" />
            <label for="floatingName">이름</label>
            <div class="invalid-feedback">
                이름을 입력해주세요.
            </div>
            <form:errors class="invalid-feedback errors" path="name"/>
        </div>

        <div class="form-floating mb-2 w-100">
            <form:input path="phoneNumber" class="form-control" id="floatingPhoneNumber" placeholder="전화번호" required="false" />
            <label for="floatingPhoneNumber">전화번호</label>
            <div class="invalid-feedback">
                전화번호를 입력해주세요.
            </div>
            <form:errors class="invalid-feedback errors" path="phoneNumber"/>
        </div>

        <input class="btn btn-outline-secondary regist-btn w-100" type="submit" value="회원가입">
    </form:form>
</div>
</body>
</html>
