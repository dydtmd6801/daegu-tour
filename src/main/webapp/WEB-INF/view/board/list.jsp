<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-08-01(001)
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>공지사항</title>
    <style>
        td {
            width: 25%;
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<c:if test="${status eq 'notFoundInfo'}">
    <script>
        window.alert("로그인 후 사용해주세요.");
    </script>
</c:if>
<h2 class="text-center my-5">공지사항</h2>
<table class="table mx-auto" style="max-width: 992px; text-align: center">
    <thead>
    <tr>
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일자</td>
    </tr>
    </thead>
    <tbody class="table-group-divider">
    <c:forEach items="${boards}" var="board" varStatus="status">
        <tr>
            <td>${board.id}</td>
            <td><a class="text-decoration-none text-dark" href="/board/detail?id=${board.id}&recentPage=${paging.nowPage}">${board.title}</a></td>
            <td>${board.writer}</td>
            <td>
                <fmt:parseDate value="${board.date}" var="date" pattern="yyyy-MM-dd"/>
                <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${paging.nowPage != 1}">
                <li class="page-item">
                    <a class="page-link" href="/board?page=${paging.nowPage - 1}" aria-label="Previous">
                        <span aria-hidden="true">이전</span>
                    </a>
                </li>
            </c:if>
            <c:forEach var="pageNumber" begin="${paging.startPage}" end="${paging.endPage}">
                <c:if test="${pageNumber == paging.nowPage}">
                    <li class="page-item active"><span class="page-link">${pageNumber}</span></li>
                </c:if>
                <c:if test="${pageNumber != paging.nowPage}">
                    <li class="page-item"><a class="page-link" href="/board?page=${pageNumber}">${pageNumber}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${paging.nowPage != paging.totalPage}">
                <li class="page-item">
                    <a class="page-link" href="/board?page=${paging.nowPage + 1}" aria-label="Next">
                        <span aria-hidden="true">다음</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
<div class="d-flex justify-content-end mx-auto" style="max-width: 992px;">
    <a class="btn btn-outline-secondary" style="margin-bottom: 30px" href="/board/write">글쓰기</a>
</div>
<footer class="w-100 border-top border-secondary">
    <div class="mx-auto" style="max-width: 992px">
        <div style="margin: 30px 20px 20px 0;">
            <a href="/index" class="fw-bold fs-4 text-decoration-none text-black">대구 관광</a>
        </div>
        <div style="padding-bottom: 30px;">
            <span style="margin-right: 15px;" class="fw-bold text-black">개발자 정보</span>
            <span style="margin-right: 15px;" class="text-secondary">유용승</span>
            <span style="margin-right: 15px;"><a href="https://github.com/dydtmd6801" target="_blank" class="text-secondary text-decoration-none">GitHub</a></span>
        </div>
    </div>
</footer>
</body>
</html>
