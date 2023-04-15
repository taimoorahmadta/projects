/* Initialising */
let myleads = [];

/* Elements */
const inputel = document.getElementById("input-el");
const inputbtn = document.getElementById("input-btn");
const olel = document.getElementById("ol-el");
const deletebtn = document.getElementById("delete-btn");
const tabbtn = document.getElementById("tab-btn");

/* Render the leads in the ordered list*/
function render(leads) {
    let listitems = "";
    for (let i = 0; i < leads.length; i++) {
        listitems += `
            <li>
                <a href="${leads[i]}" target="_blank" > ${leads[i]} </a>  
            </li>
        `;
    }
    olel.innerHTML = listitems;
}

/* get leads from localstorage (parsed)*/
const leadsfromlocalstorage = JSON.parse(localStorage.getItem("myleads"));

/* Render out leads from localstorage if present */
if (leadsfromlocalstorage) {
    myleads = leadsfromlocalstorage;
    render(myleads);
}

/* Delete everything */
deletebtn.addEventListener("dblclick", function handleDelete() {
    localStorage.clear();
    myleads = []
    render(myleads);
})

/* Save lead to localstorage and render it in the list */
inputbtn.addEventListener('click', function handlesave() {

    //if input element empty don't pass anything
    if(inputel.value != ""){
        myleads.push(inputel.value);
    }
    inputel.value = "";
    localStorage.setItem("myleads", JSON.stringify(myleads))
    render(myleads);
})

/* Save tab to localstorage and render it in the list */
tabbtn.addEventListener('click', function tabsave() {
    //fetch the current active tab url
    chrome.tabs.query({active: true, currentWindow: true}, function(tabs){
        myleads.push(tabs[0].url);  //this gets url
        // myleads.push(tabs[0].title);  //this gets title of tab
        localStorage.setItem("myleads",JSON.stringify(myleads))
        render(myleads);
    });
})

