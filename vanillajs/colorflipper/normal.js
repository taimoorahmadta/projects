const colors = ["green", "red", "rgba(133,122,200)", "#f15025"];

const btn = document.getElementById("btn");
const colorname = document.querySelector(".colorname");

//normal
btn.addEventListener('click', function(){
    let randomnum = getrandom()
    document.getElementById("container").style.backgroundColor=colors[randomnum];
    colorname.textContent = colors[randomnum]
    colorname.style.color = colors[randomnum]
})
function getrandom(){
    return Math.floor(Math.random() * colors.length)
}
