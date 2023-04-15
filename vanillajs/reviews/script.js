let imgel = document.getElementById("image-el")
let name = document.getElementById("name-el")
let headline = document.getElementById("headline-el")
let about = document.getElementById("about-el")

const prevbtn = document.getElementById("prev-btn-el")
const nextbtn = document.getElementById("next-btn-el")

/* DATA */

const persons = [
    {
        image: "images/img1.jpg",
        name: "Susan Smith",
        headline: "WEB DEVELOPER",
        about: "I'm baby meggings twee health goth +1. Bicycle rights tumeric chartreuse before they sold out chambray pop-up. Shaman humblebrag pickled coloring book salvia hoodie, cold-pressed four dollar toast everyday carry"
    },
    {
        image: "images/img2.jpg",
        name: "WEB DESIGNER",
        headline: "Tall guy",
        about: "Helvetica artisan kinfolk thundercats lumbersexual blue bottle. Disrupt glossier gastropub deep v vice franzen hell of brooklyn twee enamel pin fashion axe.photo booth jean shorts artisan narwhal."
    },
    {
        image: "images/img3.jpg",
        name: "Peter Jones",
        headline: "INTERN",
        about: "Sriracha literally flexitarian irony, vape marfa unicorn. Glossier tattooed 8-bit, fixie waistcoat offal activated charcoal slow-carb marfa hell of pabst raclette post-ironic jianbing swag."
    },
    {
        image: "images/img4.jpg",
        name: "Bill Anderson",
        headline: "THE BOSS",
        about: "Edison bulb put a bird on it humblebrag, marfa pok pok heirloom fashion axe cray stumptown venmo actually seitan. VHS farm-to-table schlitz, edison bulb pop-up 3 wolf moon tote bag street art shabby chic."
    }
];

let index = 0
render(index)

function render() {
    let currentitem = persons[index]
    imgel.src = currentitem.image;
    name.innerHTML = currentitem.name;
    headline.innerHTML = currentitem.headline;
    about.innerHTML = currentitem.about;
}

prevbtn.addEventListener('click', () => {
    index--
    if(index < 0){
        index = persons.length - 1
    }
    
    render()
    console.log(index)

})

nextbtn.addEventListener('click', () => {
    index++
    if(index > persons.length - 1){
        index = 0
    }
    render()
    console.log(index)
   
})








