<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-16(016)
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>step2</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h2>회원가입</h2>
<form:form action="step3" method="post" modelAttribute="registDto">
    <p>아이디 : <form:input path="userId" id="userId"/></p>
    <p id="result"></p>
    <p><form:errors path="userId"/></p>
    <input type="button" id="checkBtn" value="중복체크">
    <p>비밀번호 : <form:password path="password"/></p>
    <p><form:errors path="password"/></p>
    <p>비밀번호 확인 : <form:password path="confirmPassword"/></p>
    <p><form:errors path="confirmPassword"/></p>
    <p>이름 : <form:input path="name"/></p>
    <p><form:errors path="name"/></p>
    <p>전화번호 : <form:input path="phoneNumber"/></p>
    <p><form:errors path="phoneNumber"/></p>
    <input type="submit" value="회원가입">
</form:form>
<script>
    let userId = document.getElementById("userId");
    let checkBtn = document.getElementById("checkBtn");

    const checkDuplication = () => {
        let result = "";
        console.log(userId.value);
        $.ajax({
            url: "/regist/checkId",
            data: {"id": userId.value},
            type: "POST",
            async: false,
            success: function (data) {
                result = data
            },
            error: function () {
                console.log("에러")
            }
        });
        if (result === "success") {
            document.getElementById("result").innerHTML = "사용가능한 ID 입니다.";
        } else if (result === "fail") {
            document.getElementById("result").innerHTML = "중복되는 ID 입니다.";
        } else {
            document.getElementById("result").innerHTML = "ID를 입력해주세요.";
        }
    }

    checkBtn.addEventListener("click", checkDuplication);
</script>
</body>
</html>
