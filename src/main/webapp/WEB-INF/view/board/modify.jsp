<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-08-14(014)
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .table {
            max-width: 992px;
            border-top-color: #dee2e6;
            border-width: 1px;
            border-spacing: 1rem;
        }
        .errors {
            display: block !important;
        }
    </style>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../../../static/js/removeBoard.js"></script>
    <script defer src="../../../static/js/checkValidation.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">공지사항</h2>
<form:form modelAttribute="boardDto" novalidate="true" class="needs-validation">
    <table class="table mx-auto border-1 border-top">
        <input type="hidden" id="id" value="${modifyBoard.id}"/>
        <tr>
            <td class="p-3 text-end fw-semibold">제목</td>
            <td class="p-3">${modifyBoard.title}<form:hidden path="title" value="${modifyBoard.title}"/></td>
        </tr>
        <tr>
            <td class="p-3 text-end fw-semibold">작성자</td>
            <td class="p-3">${AuthInfo.userName}</td>
        </tr>
        <tr>
            <td class="p-3 text-end fw-semibold">내용</td>
            <td class="p-3 pb-5">
                <form:textarea path="content" class="w-75" rows="8" required="false"/>
                <div class="invalid-feedback">
                    내용을 입력해주세요.
                </div>
                <form:errors class="invalid-feedback errors" path="content"/>
            </td>
        </tr>
        <tr>
            <td class="p-3 text-end fw-semibold">비밀번호</td>
            <td class="p-3">
                <form:password path="password" class="w-75" required="false"/>
                <div class="invalid-feedback">
                    비밀번호를 입력해주세요.
                </div>
                <form:errors class="invalid-feedback errors" path="password"/>
            </td>
        </tr>
    </table>
    <div class="text-center">
        <a href="/board/detail?id=${modifyBoard.id}" class="btn btn-outline-secondary">취소</a>
        <input type="button" id="removeBtn" class="btn btn-outline-secondary" value="삭제"/>
        <input type="submit" class="btn btn-outline-secondary" value="완료"/>
    </div>
</form:form>
</body>
</html>
