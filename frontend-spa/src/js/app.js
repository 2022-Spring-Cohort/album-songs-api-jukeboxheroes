//i think itll start with a fetch
import home from "./ul.js";

fetch("localhost:8080/")
    .then(res => res.json())
    .then(albums => {
        console.log(albums)
        const containerEl = document.querySelector(".container");
        containerEl.innerHTML = home(albums);
    })

const bodyEl = document.querySelector(".body");
const headerEl = document.querySelector(".h1");
const listEl = document.querySelector(".unordered-list");
const listitemEl = document.querySelector(".list-item");
const audioEl = document.querySelector(".audioStuff");









//<h3 class="campus-tech-stack">${album.song}</h3> dont think we will need this atleast not yet