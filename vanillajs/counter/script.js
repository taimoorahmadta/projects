const counter = document.getElementById("counterel")
const decrease = document.getElementById("decreaseel");
const increase = document.getElementById("increaseel");
const reset = document.getElementById("resetel");

let count = 0
counter.textContent = count;
colorchange()

//change color w.r.t the number
function colorchange(){
    if(counter.textContent > 0){
        document.getElementById("counterel").style.color = "green";
    }else if(counter.textContent < 0){
        document.getElementById("counterel").style.color = "red";
    }else{
        document.getElementById("counterel").style.color = "grey";
    }
}

//decrease
decrease.addEventListener('click', function(){
    count--;
    counter.textContent = count;
    colorchange()
})

//increase
increase.addEventListener('click', function(){
    count++;
    counter.textContent = count;
    colorchange()
})

//reset
reset.addEventListener('click', function(){
    count = 0;
    counter.textContent = count;
    colorchange()
})

