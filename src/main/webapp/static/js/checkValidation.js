const loginBtn = document.querySelector(".btn");
const inputHeight = document.querySelector(".form-control").clientHeight;
const forms = document.querySelectorAll('.needs-validation');
const errors = document.querySelectorAll(".errors");

loginBtn.style.height = inputHeight + "px";

loginBtn.addEventListener("click", () => {
    errors.forEach(error => {
        error.remove();
    })
})

Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
        if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
        }

        form.classList.add('was-validated')
    }, false)
})