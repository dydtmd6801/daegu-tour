const forms = document.querySelectorAll('.needs-validation');
const formControls = document.querySelectorAll(".form-control");
const errors = document.querySelectorAll(".errors");

Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
        if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
        }

        form.classList.add('was-validated')
    }, false)
})

formControls.forEach(formControl => {
    formControl.addEventListener("keyup", () => {
        console.log(formControl);
        errors.forEach(error => {
            error.classList.remove("errors");
        })
    })
})

$(".regist-btn").on({
    click: function (event) {
        event.preventDefault();
        if(authFlag !== 1) {
            alert("이메일 인증이 필요합니다.");
            return;
        }
        if(!$("#direct").is(":checked")) {
            $("#email").val($("#email").val() + $("#email2").val());
        }
        $("#registDto").submit();
        return;
    }
})