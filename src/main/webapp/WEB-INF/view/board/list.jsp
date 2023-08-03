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
<jsp:include page="../header.jsp" />
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
            <td>${fn:length(boards) - status.index}</td>
            <td><a class="text-decoration-none text-dark" href="/board/detail?id=${board.id}">${board.title}</a></td>
            <td>${board.writer}</td>
            <td>
                <fmt:parseDate value="${board.date}" var="date" pattern="yyyy-MM-dd"/>
                <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
