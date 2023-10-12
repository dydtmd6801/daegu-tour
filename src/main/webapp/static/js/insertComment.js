const boardId = new URL(window.location.href).searchParams.get("id");
const userName = document.querySelector("#userName").textContent;
$("#inputComment").on({
    click: function() {
        let content = document.querySelector("#content");
        $.ajax({
            url: "/board/insertComment",
            data: {"userName":userName, "content":content.value, "boardId":boardId},
            type: "POST",
            success: function (data) {
                $("#commentList").load(location.href+' #commentList');
                content.value = null;
            },
            error: function () {
                console.log("에러");
            }
        })
    }
})