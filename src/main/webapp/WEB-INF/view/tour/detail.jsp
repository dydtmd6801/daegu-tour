<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-07-07(007)
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세정보</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2 class="text-center my-5">상세정보</h2>
<div class="d-flex flex-column mx-auto" style="width: 58rem">
    <div class="card mb-3 w-100">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="${tourInfo[tourDetail.contentId].thumbnailImage}" class="img-fluid rounded-start object-fit-cover" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title fw-bold fs-4">${tourInfo[tourDetail.contentId].title}</h5>
                    <p class="card-text">주소 : ${tourInfo[tourDetail.contentId].address}</p>
                    <p class="card-text">주차정보 : ${tourDetail.parkingInfo}</p>
                    <p class="card-text">연락처 : ${tourDetail.infoCenter}</p>
                </div>
            </div>
        </div>
    </div>
    ${tourDetail.overview}
</div>
</body>
</html>
