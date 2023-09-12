const logoutBtn = document.querySelector("#logout");

logoutBtn.addEventListener("click", () => {
    $.ajax({
        url: "/logout",
        type: "get",
        success: () => {
            window.alert("로그아웃 되었습니다.");
            window.location.href="/index";
        },
    })
})