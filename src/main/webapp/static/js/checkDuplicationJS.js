let userId = document.getElementById("userId");
let checkBtn = document.getElementById("checkBtn");

const checkDuplication = () => {
    console.log(userId.value);
    $.ajax({
        url: "/regist/checkId",
        data: {"id": userId.value},
        type: "POST",
        success: function (data) {
            if (data === "success") {
                document.getElementById("result").innerHTML = "사용가능한 ID 입니다.";
            } else if (data === "fail") {
                document.getElementById("result").innerHTML = "중복되는 ID 입니다.";
            } else {
                document.getElementById("result").innerHTML = "ID를 입력해주세요.";
            }
        },
        error: function () {
            console.log("에러");
        }
    });
}

checkBtn.addEventListener("click", checkDuplication);