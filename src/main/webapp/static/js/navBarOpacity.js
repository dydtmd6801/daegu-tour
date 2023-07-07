const navBar = document.querySelector(".navbar");
let opacity = 1;

navBar.addEventListener("mouseover", () => {
    changeOpacity(opacity);
})

navBar.addEventListener("mouseout", () => {
    navBar.style.removeProperty("background-color");
})

const changeOpacity = (opacity) => {
    navBar.style.backgroundColor = `rgba(255,255,255,${opacity})`;
}