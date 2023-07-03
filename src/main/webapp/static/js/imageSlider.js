const slider = document.querySelector("#slider");
const slides = slider.querySelector(".slides");
const slide = slides.querySelectorAll(".slide");

let currentSlide = 0;

for(let i = 0; i < slide.length; i++) {
    slide[i].style.width = slider.clientWidth + "px";
    if(i === slide.length-1) {
        continue;
    }
}

setInterval(function () {
    let from = -(slider.clientWidth * currentSlide);
    let to = from - slider.clientWidth;
    slides.animate(
        {
            marginLeft: [from + "px", to + "px"],
        },
        {
            duration: 500,
            easing: "ease",
            iterations: 1,
            fill: "both",
        }
    );
    currentSlide++;
    if (currentSlide === slide.length - 1) {
        currentSlide = 0;
    }
}, 3000);