import home from "./home.js";
import albumView from "./albumView.js";
import {albums} from "./albumJson.js";

const containerEl = document.querySelector(".container");

function makeHomeView() {
fetch("http://localhost:8080/albums")
    .then(res => res.json())
    .then(albums => {
        console.log(albums)
        containerEl.innerHTML = home(albums);
    })
}

function makeAlbumView(albumId){
    fetch("http://localhost:8080/albums/" + albumId)
        .then(res => res.json())
        .then(album =>{
            containerEl.innerHTML = albumView(albums);

            const albumEl = containerEl.querySelectorAll(".list-item");

            albumEl.forEach(album => {
                album.addEventListener("click", () =>{
                    let albumIdEl = album.querySelector(".id-field")
                    makeAlbumView(albumIdEl.value);
                })
            })
        })
}

makeHomeView();






//<h3 class="campus-tech-stack">${album.song}</h3> dont think we will need this atleast not yet