<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-09-14(014)
  Time: 오후 5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .errors{
            display: block !important;
        }
    </style>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../../../static/js/removeClass.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">회원정보</h2>
<form:form modelAttribute="changeUserInfoDto" action="/userInfo/update">
    <div class="mx-auto" style="width: 35%">
        <div class="w-100 d-flex flex-row justify-content-between align-items-center mb-3">
            <p class="fs-6 fw-bold">아이디 : </p>
            <form:hidden path="userId" value="${userInfo.userId}"/>
            <p>${userInfo.userId}</p>
        </div>
        <div class="w-100 d-flex flex-row justify-content-between align-items-center mb-3">
            <p class="fs-6 fw-bold">이름 : </p>
            <div class="text-end">
                <form:input class="form-control" path="name" value="${userInfo.name}"/>
                <form:errors path="name" class="invalid-feedback errors"/>
            </div>
        </div>
        <div class="w-100 d-flex flex-row justify-content-between align-items-center mb-3">
            <p class="fs-6 fw-bold">전화번호 : </p>
            <div class="text-end">
                <form:input class="form-control" path="phoneNumber" value="${userInfo.phoneNumber}"/>
                <form:errors path="phoneNumber" class="invalid-feedback errors"/>
            </div>
        </div>
        <div class="w-100 d-flex flex-row justify-content-between align-items-center mb-3">
            <p class="fs-6 fw-bold">이메일 : </p>
            <div class="text-end">
                <form:input class="form-control" path="email" value="${userInfo.email}"/>
                <form:errors path="email" class="invalid-feedback errors"/>
            </div>
        </div>

        <button class="btn btn-outline-secondary mx-auto d-block">수정완료</button>
    </div>
</form:form>
</body>
</html>
