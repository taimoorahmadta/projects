
function person(name){
    this.name = name;
    this.intro = function(){
        console.log("Hey, I am introducing myself")
    }
}

const p1 = new person("taimoor")