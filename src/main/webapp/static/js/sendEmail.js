let code;
let authFlag = 0;

$("#checkMailBtn").click(function () {
    let email = "";
    if ($("#direct").is(":checked")) {
        email = $("#email").val();
    } else {
        email = $("#email").val() + $("#email2").val();
    }

    $.ajax({
        url: "/regist/checkMailAuth",
        data: {"email": email},
        type: "GET",
        success: function(data) {
            $("#inputAuthPassword").removeAttr("style");
            code = data;
            alert("인증번호가 전송되었습니다.");
        },
        error: function(request, status, error) {
            alert("code : " + request.status + "\n message : " + request.responseText + "\n error : " + error);
        }
    })
})

const authResult = $("#authResult")

$("#checkAuth").click(function () {
    if ($("#authPassword").val() === code) {
        authResult.html("인증이 완료되었습니다.");
        authResult.css("color", "#198754");
        authFlag = 1;
        return;
    }
    authResult.html("인증번호가 올바르지 않습니다.");
    authResult.css("color","#dc3545");
    authFlag = 0;
})