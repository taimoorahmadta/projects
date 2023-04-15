const hexcolors = [1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F'];

const btn = document.getElementById("btn");
const colorname = document.querySelector(".colorname");


//hex
btn.addEventListener('click', function(){
    let temp = getcolor()
    document.getElementById("container").style.backgroundColor= temp;
    colorname.textContent = temp
    colorname.style.color = temp
})
function getcolor(){
    let col = '#'
    for(let i=0; i<6; i++){
        let num = Math.floor(Math.random() * hexcolors.length)
        col += hexcolors[num]
    }
    return col
}