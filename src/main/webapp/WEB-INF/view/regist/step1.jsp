<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-15(015)
  Time: 오후 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>step1</title>
    <link rel="stylesheet" href="../../../static/css/font.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script defer src="../../../static/js/checkValidation.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="m-auto mt-5 w-25 d-flex flex-column align-items-center">
    <h1 class="display-5 mb-5">회원가입</h1>
    <label class="form-label w-100">개인정보활용동의<textarea class="form-control" rows="10" readonly>...</textarea></label>
    <form class="needs-validation w-100 d-flex flex-column align-items-center" action="step2" method="post" novalidate>
        <div class="d-flex flex-row flex-wrap me-auto">
            <label class="form-check-label me-2" for="invalidCheck">동의</label>
            <input class="form-check-input me-auto" type="checkbox" name="agree" id="invalidCheck" required/>
            <div class="invalid-feedback">동의가 필수입니다.</div>
        </div>
        <input type="submit" class="btn btn-outline-secondary w-50 mt-3" value="다음단계"/>
    </form>
</div>
</body>
</html>
