const navBar = document.querySelector(".navbar");
let opacity = 1;

navBar.addEventListener("mouseover", () => {
    changeOpacity(opacity);
})

navBar.addEventListener("mouseout", () => {
    changeOpacity(opacity-opacity);
})

const changeOpacity = (opacity) => {
    navBar.style.backgroundColor = `rgba(255,255,255,${opacity})`;
}