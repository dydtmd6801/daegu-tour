<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-09-15(015)
  Time: 오후 5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">비밀번호 변경</h2>
<form:form style="width:35%" class="mx-auto" modelAttribute="changeUserPasswordDto">
    <div class="form-floating mb-2 w-100">
        <form:password path="currentPassword" class="form-control" placeholder="현재 비밀번호"/>
        <label for="currentPassword">현재 비밀번호</label>
    </div>
    <div class="form-floating mb-2 w-100">
        <form:password path="newPassword" class="form-control" placeholder="새 비밀번호"/>
        <label for="newPassword">새 비밀번호</label>
    </div>
    <div class="form-floating mb-2 w-100">
        <form:password path="newConfirmPassword" class="form-control" placeholder="새 비밀번호 확인"/>
        <label for="newConfirmPassword">새 비밀번호 확인</label>
    </div>
    <button class="btn btn-outline-secondary w-100" style="height: 58px;">수정하기</button>
</form:form>
</body>
</html>
