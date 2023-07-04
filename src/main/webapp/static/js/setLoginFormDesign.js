const loginBtn = document.querySelector(".loginBtn");
const inputHeight = document.querySelector(".form-control").clientHeight;
const errors = document.querySelectorAll(".errors");

loginBtn.style.height = inputHeight + "px";

loginBtn.addEventListener("click", () => {
    errors.forEach(error => {
        error.remove();
    })
})