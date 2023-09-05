let code;

$("#checkMailBtn").click(function () {
    const email = $("#email").val() + "@" + $("#email2").val();
    const authPassword = $("inputAuthPassword");

    $.ajax({
        url: "/regist/checkMailAuth",
        data: {"email": email},
        type: "get",
        success: function(data) {
            authPassword.removeAttr("display");
            code = data;
            alert("인증번호가 전송되었습니다.");
        }
    })
})

