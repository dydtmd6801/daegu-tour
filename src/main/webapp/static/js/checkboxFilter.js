let filters = document.querySelectorAll(".filter");
let gugun = document.querySelectorAll(".gugun");
let filterStr = "";

filters.forEach(filter => {
    filter.addEventListener("change", () => {
        for(let i = 0; i < filters.length; i++) {
            if(filters[i].checked) {
                filterStr += filters[i].id + ".";
                gugun[i].style.backgroundColor="#f00";
            } else {
                gugun[i].style.backgroundColor="#0f0";
            }
        }
        console.log(filterStr);
        filterStr = "";
    })
});