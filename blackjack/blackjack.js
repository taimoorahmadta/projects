sum = 0;
let hasblackjack = false;
let isalive = true;
let message = "";
let cardarray = [];
let newgamepossible = false;

//these variables capture the elements
let messageel = document.getElementById("message-el");
let sumel = document.getElementById("sum-el");
let cardel = document.getElementById("card-el");

let  playerel = document.getElementById("player-el");

let player = {
    name: "Taimoor Ahmad",
    chips: 145
}

playerel.textContent = player.name + ": $"+ player.chips;




// A function to generate random number btw range 1 - 13
// For ease 1(ace card) = 11 and 11-13(Joker, King, Queen) = 10
function getrandomcard() {
    const min = 1;
    const max = 13;
    const randomNum = Math.floor(Math.random() * (max - min + 1)) + min;
    if (randomNum === 1) {
        return 11;
    } else if (randomNum >= 11 && randomNum <= 13) {
        return 10;
    } else {
        return randomNum;
    }
}

function rendergame() {
    sumel.textContent = "Sum: " + sum;/*the value of sum is calculated in the "startgame()" or "newcard()" functions*/

    /* this code outputs the card values stored in cardarray in front of "Cards: " */
    cardel.textContent = "Cards: ";
    for (let i = 0; i < cardarray.length; i++) {
        cardel.textContent += cardarray[i] + " ";
    }
 
    /* conditions */
    if (sum < 21) {
        message = ("Wanna draw new cards? 🤔");
        newgamepossible = false;
    } else if (sum === 21) {
        message = ("Yaay! You are blackjack. 🥳");
        hasblackjack = true;
        newgamepossible = true;
    } else {
        message = ("You are out! 😭");
        isalive = false;
        newgamepossible = true;
    }

    messageel.textContent = message /* the output message*/

}

/*  Generates 2 initial cards to start game*/
function startgame() {
    if (cardarray.length == 0 || newgamepossible == true) {
        cardarray = [] // Discard the previous values in front of "Card: "
        cardarray[0] = getrandomcard();
        cardarray[1] = getrandomcard();
        sum = cardarray[0] + cardarray[1];
        rendergame();
    }
}

/*generate as many new cards until inside a game
    is alive and has not blackjacked 
    and the first 2 cards have been generated */
function newcard() {
    if (cardarray.length != 0 && newgamepossible == false) {
        let card = getrandomcard();
        sum += card;
        cardarray.push(card);
        rendergame();
    }
}


