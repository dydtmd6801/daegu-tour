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
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../../../static/js/insertComment.js"></script>
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
<div class="mx-auto" style="max-width: 992px" id="commentList">
    <c:forEach var="comment" items="${comments}">
        <div class="p-3 border-1 border-dark-subtle border-bottom d-flex flex-row align-items-center">
            <span class="fw-bold" style="width: 10%">${comment.userName}</span>
            <span>${comment.content}</span>
        </div>
    </c:forEach>
</div>
<c:if test="${!empty AuthInfo}">
    <div class="mx-auto " style="max-width: 992px">
        <div class="p-3 border-1 border-dark-subtle border-bottom d-flex flex-row align-items-center">
            <span class="fw-bold" style="width: 10%" id="userName">${AuthInfo.userName}</span>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="댓글을 입력해주세요" id="content"/>
                <button class="btn btn-outline-secondary" type="button" id="inputComment">댓글 입력</button>
            </div>
        </div>
    </div>
</c:if>
<div class="text-center">
    <c:if test="${!empty AuthInfo}">
        <a class="btn btn-outline-secondary mt-3"
           href="/board/modify?id=${boardDetail.id}&recentPage=${recentPage}">수정</a>
    </c:if>
    <a class="btn btn-outline-secondary mt-3" href="/board?page=${recentPage}">목록</a>
</div>
</body>
</html>
