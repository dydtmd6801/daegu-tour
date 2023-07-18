<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="tourList" class="d-flex flex-wrap justify-content-center">
    <c:forEach items="${tourList}" var="tourList">
        <div class="card" style="width: 18rem; margin: 1rem;">
            <img src="${tourList.value.thumbnailImage}" style="width:100%; height: 12rem"
                 class="card-img-top object-fit-cover" alt="..."/>
            <div class="card-body d-flex flex-column justify-content-between">
                <h5 class="card-title">${tourList.value.title}</h5>
                <p class="card-text small">${tourList.value.address}</p>
                <a href="/tour/detail?tourId=${tourList.value.contentId}" class="btn btn-primary ">상세보기</a>
            </div>
        </div>
    </c:forEach>
</div>