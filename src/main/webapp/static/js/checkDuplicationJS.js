let userId = document.getElementById("userId");
let checkBtn = document.getElementById("checkBtn");
let result = document.getElementById("result");

checkBtn.style.height = userId.offsetHeight + "px";

const checkDuplication = () => {
    $.ajax({
        url: "/regist/checkId",
        data: {"id": userId.value},
        type: "POST",
        success: function (data) {
            if (data === "success") {
                result.innerHTML = "사용가능한 ID 입니다.";
                result.style.color = "#198754";
            } else if (data === "fail") {
                result.innerHTML = "중복되는 ID 입니다.";
                result.style.color = "#dc3545";
            } else {
                result.innerHTML = "ID를 입력해주세요.";
                result.style.color = "#dc3545";
            }
        },
        error: function () {
            console.log("에러");
        }
    });
}

checkBtn.addEventListener("click", checkDuplication);