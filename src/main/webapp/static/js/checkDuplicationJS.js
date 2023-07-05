let userId = document.getElementById("userId");
let checkBtn = document.getElementById("checkBtn");
let result = document.getElementById("result");
let errors = document.querySelectorAll(".errors");

let userIdValue = ""

checkBtn.style.height = userId.offsetHeight + "px";

const checkDuplication = () => {
    userIdValue = userId.value;
    $.ajax({
        url: "/regist/checkId",
        data: {"id": userIdValue},
        type: "POST",
        success: function (data) {
            if (data === "success") {
                result.innerHTML = "사용가능한 ID 입니다.";
                result.style.color = "#198754";
            } else if (data === "fail") {
                result.innerHTML = "중복되는 ID 입니다.";
                result.style.color = "#dc3545";
            } else {
                result.innerHTML = "올바르지 않은 형식입니다.";
                result.style.color = "#dc3545";
            }
        },
        error: function () {
            console.log("에러");
        }
    });
}

const changeUserIdValue = () => {
    if (userIdValue !== userId.value) {
        result.innerHTML = "";
        errors[1].innerHTML = "";
    }
}

checkBtn.addEventListener("click", checkDuplication);
userId.addEventListener("keydown", changeUserIdValue);
userId.addEventListener("keyup", changeUserIdValue);