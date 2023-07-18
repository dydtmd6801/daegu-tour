let filters = document.querySelectorAll(".filter");
let gugun = document.querySelectorAll(".gugun");
let filterStr = "";

filters.forEach(filter => {
    filter.addEventListener("change", () => {
        for(let i = 0; i < filters.length; i++) {
            if(filters[i].checked) {
                filterStr += filters[i].id + ".";
                gugun[i].style.backgroundColor="#6c757d";
                gugun[i].style.color="#ffffff";
            } else {
                gugun[i].style.removeProperty("color");
                gugun[i].style.removeProperty("background-color");
            }
        }
        $.ajax({
            url: "/tour/tourFilter",
            data: {"filter": filterStr},
            type: "GET",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            success: function (data) {
                $('#tourList').html(data);
            },
            error: function () {
                console.log("에러");
            }
        });
        filterStr = "";
    })
});