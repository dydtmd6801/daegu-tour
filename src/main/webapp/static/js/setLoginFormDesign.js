const loginBtn = document.querySelector(".loginBtn");
const inputHeight = document.querySelector(".form-control").clientHeight;
const errors = document.querySelectorAll(".errors");
const naverLogin = document.querySelector("#naverLogin");

loginBtn.style.height = inputHeight + "px";
naverLogin.style.height = inputHeight + "px";

loginBtn.addEventListener("click", () => {
    errors.forEach(error => {
        error.remove();
    })
})