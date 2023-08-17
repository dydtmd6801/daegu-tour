const removeBtn = document.querySelector("#removeBtn");

const remove = () => {
    const password = document.querySelector("#password").value;
    const id = document.querySelector("#id").value;
    $.ajax({
        url: "/board/remove",
        data: {"id": id, "password": password},
        type: "POST",
        success: function (data) {
            if(data === "success") {
                window.location.replace("/board");
                window.alert("해당 게시글이 삭제되었습니다.");
            }
            if(data === "fail"){
                window.alert("비밀번호가 일치하지 않습니다.");
            }
        },
        error: function () {
            console.log("에러");
        }
    })
}

removeBtn.addEventListener("click", remove);