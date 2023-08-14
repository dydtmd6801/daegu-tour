<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-08-07(007)
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
    <style>
        .table {
            max-width: 992px;
            border-top-color: #dee2e6;
            border-width: 1px;
            border-spacing: 1rem;
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">공지사항</h2>
<form:form modelAttribute="boardDto">
    <table class="table mx-auto border-1 border-top">
        <tr>
            <td class="p-3 text-end fw-semibold">제목</td>
            <td class="p-3"><form:input path="title" class="w-75"/></td>
        </tr>
        <tr>
            <td class="p-3 text-end fw-semibold">작성자</td>
            <td class="p-3">${AuthInfo.userName}<form:hidden path="writer" value="${AuthInfo.userName}"/></td>
        </tr>
        <tr>
            <td class="p-3 text-end fw-semibold">내용</td>
            <td class="p-3 pb-5"><form:textarea path="content" class="w-75" rows="8"/></td>
        </tr>
        <tr>
            <td class="p-3 text-end fw-semibold">비밀번호</td>
            <td class="p-3"><form:password path="password" class="w-75"/></td>
        </tr>
    </table>
    <div class="text-center">
        <a href="/board" class="btn btn-outline-secondary">취소</a>
        <button class="btn btn-outline-secondary">완료</button>
    </div>
</form:form>
</body>
</html>
