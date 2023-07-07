<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-23(023)
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TourList</title>
    <link rel="stylesheet" href="../../../static/css/font.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script defer src="../../../static/js/checkboxFilter.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>관광 리스트</h2>
<div>
    <div>
        <label class="gugun" for="dalseo">달서구</label>
        <label class="gugun" for="buk" >북구</label>
        <label class="gugun" for="susung">수성구</label>
        <label class="gugun" for="dong">동구</label>
        <label class="gugun" for="dalsung">달성군</label>
        <label class="gugun" for="seo">서구</label>
        <label class="gugun" for="nam">남구</label>
        <label class="gugun" for="jung">중구</label>
        <label class="gugun" for="gunwi">군위군</label>
    </div>
    <div style="display: none;">
        <input type="checkbox" class="filter" id="dalseo"/>
        <input type="checkbox" class="filter" id="buk"/>
        <input type="checkbox" class="filter" id="susung"/>
        <input type="checkbox" class="filter" id="dong"/>
        <input type="checkbox" class="filter" id="dalsung"/>
        <input type="checkbox" class="filter" id="seo"/>
        <input type="checkbox" class="filter" id="nam"/>
        <input type="checkbox" class="filter" id="jung"/>
        <input type="checkbox" class="filter" id="gunwi"/>
    </div>
</div>
<div class="d-flex flex-wrap justify-content-center">
    <c:forEach items="${tourList}" var="tourList">
        <div class="card" style="width: 18rem; margin: 1rem;">
            <img src="${tourList.value.thumbnailImage}" class="card-img-top" alt="..."/>
            <div class="card-body">
                <h5 class="card-title">${tourList.value.title}</h5>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
