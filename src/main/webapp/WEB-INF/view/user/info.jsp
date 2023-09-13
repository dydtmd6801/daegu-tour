<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-09-13(013)
  Time: 오전 10:04
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
<c:if test="${empty userInfo}">
    <form:form modelAttribute="changeUserInfoDto" style="width: 35%"
               class="needs-validation m-auto mt-5 d-flex flex-column align-items-center">
        <div class="input-group mb-2 w-100">
            <div class="form-floating">
                <form:password path="password" class="form-control" required="false" placeholder="비밀번호"/>
                <label for="password">비밀번호</label>
                <div class="invalid-feedback">
                    비밀번호를 입력해주세요.
                </div>
            </div>
            <button class="btn btn-outline-secondary">확인</button>
        </div>
        <form:errors class="invalid-feedback errors mb-2" path="password"/>
    </form:form>
</c:if>
<c:if test="${!empty userInfo}">
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
                <p>${userInfo.name}</p>
                <p>${userInfo.phoneNumber}</p>
                <p>${userInfo.email}</p>
            </div>
        </div>
        <a href="/userInfo/edit" class="btn btn-outline-secondary mx-auto d-block">수정</a>
    </div>
</c:if>
</body>
</html>
