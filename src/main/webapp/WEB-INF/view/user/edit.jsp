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
<form:form modelAttribute="changeUserInfoDto">
    <div class="mx-auto" style="width: 35%">
        <div class="w-100">
            <div class="w-50 float-start fs-6 fw-bold">
                <p>아이디 :</p>
                <p>이름 :</p>
                <p>전화번호 :</p>
                <p>이메일 :</p>
            </div>
            <div class="w-50 float-end text-end fs-6">
                <p>${userInfo.userId}</p>
                <p><form:input path="name" value="${userInfo.name}"/> </p>
                <p><form:input path="phoneNumber" value="${userInfo.phoneNumber}"/></p>
                <p><form:input path="email" value="${userInfo.email}"/></p>
            </div>
        </div>
        <button class="btn btn-outline-secondary mx-auto d-block">수정</button>
    </div>
</form:form>
</body>
</html>
