import home from "./home.js";
import {albums} from "./albumJson.js";

const containerEl = document.querySelector(".container");

function makeHomeView() {
fetch("localhost:8080/albums")
    .then(res => res.json())
    .then(albums => {
        console.log(albums)
        containerEl.innerHTML = home(albums);
    })
}

makeHomeView();






//<h3 class="campus-tech-stack">${album.song}</h3> dont think we will need this atleast not yet