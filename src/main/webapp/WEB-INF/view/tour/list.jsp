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
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../../../static/js/checkboxFilter.js"></script>
    <script defer src="../../../static/js/searchFilter.js"></script>
    <style>
        .gugun {
            margin: 1rem;
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">관광지 목록</h2>
<div class="input-group mb-3 w-50 mx-auto">
    <span class="input-group-text" id="searchTourList"><img src="../../../static/img/search.png" width="20px"/></span>
    <input type="text" id="searchBar" class="form-control" placeholder="검색어를 입력해 주세요." aria-describedby="searchTourList" />
    <button class="btn btn-outline-secondary" type="button" id="searchBtn">검색</button>
</div>
<div class="d-flex justify-content-center">
    <div class="d-flex justify-content-between">
        <label class="gugun btn btn-outline-secondary btn-sm" for="달서구">달서구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="북구" >북구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="수성구">수성구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="동구">동구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="달성군">달성군</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="서구">서구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="남구">남구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="중구">중구</label>
        <label class="gugun btn btn-outline-secondary btn-sm" for="군위군">군위군</label>
    </div>
    <div style="display: none;">
        <input type="checkbox" class="filter" id="달서구"/>
        <input type="checkbox" class="filter" id="북구"/>
        <input type="checkbox" class="filter" id="수성구"/>
        <input type="checkbox" class="filter" id="동구"/>
        <input type="checkbox" class="filter" id="달성군"/>
        <input type="checkbox" class="filter" id="서구"/>
        <input type="checkbox" class="filter" id="남구"/>
        <input type="checkbox" class="filter" id="중구"/>
        <input type="checkbox" class="filter" id="군위군"/>
    </div>
</div>
<div id="tourList" class="d-flex flex-wrap justify-content-center">
    <c:forEach items="${tourList}" var="tourList">
        <div class="card" style="width: 18rem; margin: 1rem;">
            <img src="${tourList.value.thumbnailImage}" style="width:100%; height: 12rem" class="card-img-top object-fit-cover" alt="..."/>
            <div class="card-body d-flex flex-column justify-content-between">
                <h5 class="card-title">${tourList.value.title}</h5>
                <p class="card-text small">${tourList.value.address}</p>
                <a href="/tour/detail?tourId=${tourList.value.contentId}" class="btn btn-primary ">상세보기</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
