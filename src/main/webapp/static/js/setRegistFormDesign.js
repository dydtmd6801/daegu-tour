let registBtn = document.querySelector(".regist-btn");
let inputHeight = document.querySelector(".form-control").clientHeight;

registBtn.style.height = inputHeight + "px";

$("#direct").click(function() {
    if ($("#direct").is(":checked")) {
        $("#email2").hide();
    } else {
        $("#email2").show();
    }
})