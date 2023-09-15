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
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">회원정보</h2>
<form:form modelAttribute="changeUserInfoDto" action="/user/update">
    <div class="mx-auto" style="width: 35%">
        <div class="w-100 d-flex flex-row justify-content-between align-items-center">
            <p class="fs-6 fw-bold">아이디 : </p>
            <p>${userInfo.userId}</p>
        </div>
        <div class="w-100 d-flex flex-row justify-content-between align-items-center">
            <p class="fs-6 fw-bold">이름 : </p>
            <p><form:input class="form-control" path="name" value="${userInfo.name}"/></p>
        </div>
        <div class="w-100 d-flex flex-row justify-content-between align-items-center">
            <p class="fs-6 fw-bold">전화번호 : </p>
            <p><form:input class="form-control" path="phoneNumber" value="${userInfo.phoneNumber}"/></p>
        </div>
        <div class="w-100 d-flex flex-row justify-content-between align-items-center">
            <p class="fs-6 fw-bold">이메일 : </p>
            <p><form:input class="form-control" path="email" value="${userInfo.email}"/></p>
        </div>
        <button class="btn btn-outline-secondary mx-auto d-block">수정완료</button>
    </div>
</form:form>
</body>
</html>
