const searchBtn = document.querySelector("#searchBtn");

const allDeSelect = () => {
    for(let target of gugun) {
        target.style.removeProperty("color");
        target.style.removeProperty("background-color");
    }
}

const allUnCheck = () => {
    for(let target of filters) {
        target.checked = false;
    }
}

const searchFilter = () => {
    const searchWord = document.querySelector("#searchBar").value;
    $.ajax({
        url: "/tour/tourSearch",
        data: {"search":searchWord},
        type: "GET",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data) {
            allDeSelect();
            allUnCheck();
            $('#tourList').html(data);
        },
        error: function () {
            console.log("에러");
        }
    })
}

searchBtn.addEventListener("click",searchFilter);