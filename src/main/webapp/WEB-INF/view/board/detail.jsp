<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-08-04(004)
  Time: 오전 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">공지사항</h2>
<div class="mx-auto d-flex flex-column align-item-center border-top border-2 border-black" style="max-width: 992px;">
    <div class="fs-5 border-bottom border-1 border-dark p-3 text-center">${boardDetail.title}</div>
    <div class="p-3 text-center bg-secondary-subtle border-1 border-dark-subtle border-bottom">
        <span class="fw-semibold">작성자 : </span>
        <span>${boardDetail.writer}</span>
        <span> | </span>
        <span class="fw-semibold">작성일자 : </span>
        <span>${boardDetail.date}</span>
    </div>
    <div class="p-3 border-1 border-dark-subtle border-bottom">${boardDetail.content}</div>
</div>
<div class="text-center">
    <c:if test="${auth eq 'Y'}">
        <a class="btn btn-outline-secondary mt-3" href="/modify">수정</a>
    </c:if>
    <a class="btn btn-outline-secondary mt-3" href="/board">목록</a>
</div>
</body>
</html>
