import home from "/js/home.js";
import albumView from "/js/albumView.js";
import { albums } from "/js/albumJson.js";

const containerEl = document.querySelector(".container");

function makeHomeView() {
    fetch("http://localhost:8080/albums")
        .then(res => res.json())
        .then(albums => {
            makeHomeViewFromJSON(albums);
        })
}

function makeHomeViewFromJSON(albums) {
    console.log(albums)
    containerEl.innerHTML = home(albums);

    const albumEl = containerEl.querySelectorAll(".album");



    // albumEl.forEach(album => {
    //     let album2 = album.querySelector(".id_field");

    // })


    albumEl.forEach(album => {
        let albumIdEl = album.querySelector(".id_field");
        const albumH2 = album.querySelector(".album-image");
        albumH2.addEventListener("click", () => {
            albums.forEach(albumJson => {
                if (albumJson.id == albumIdEl.value) {
                    makeAlbumView(albumJson);

                }
            })
            // alert("You clicked me: " + campusIdEl.value);
        })
        const deleteButton = album.querySelector(".delete-button");
        deleteButton.addEventListener("click", () => {
            fetch("http://localhost:8080/albums/" + albumIdEl.value, {
                method: 'DELETE'
            })
                .then(res => res.json())
                .then(newAlbums => {
                    makeHomeViewFromJSON(newAlbums);
                })
        })
        const updateButton = album.querySelector(".update-button");
        updateButton.addEventListener("click", () => {
            const updateInput = album.querySelector(".update-title");
            fetch("http://localhost:8080/albums/" + albumIdEl.value, {
                method: 'PATCH',
                body: updateInput.value
            })
                .then(res => res.json())
                .then(newAlbums => {
                    makeHomeViewFromJSON(newAlbums);
                })
        })

        const addAlbumCommentBtn = album.querySelector(".addAlbumCommentBtn");

        const albumCommentInput = album.querySelector(".albumCommentInput");
        const albumCommentRating = album.querySelector("#starRating");
        if (albumCommentInput != null) {
            addAlbumCommentBtn.addEventListener("click", () => {
                const newSongJson = {
                    "body": albumCommentInput.value,
                    "rating": albumCommentRating.value
                }
                fetch(`http://localhost:8080/albums/${albumIdEl.value}/addAlbumComment`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(newSongJson)
                })
                    .then(res => res.json())
                    .then(newAlbums => {
                        makeHomeViewFromJSON(newAlbums);
                    })
            })
        }
    })
    const addAlbumBtn = containerEl.querySelector(".add-album-button")

    const addAlbumInput = containerEl.querySelector(".add-album")
    const addAlbumImage = containerEl.querySelector("#img");
    if (addAlbumInput != null) {
        addAlbumBtn.addEventListener("click", () => {
            const newAlbumJson = {
                "title": addAlbumInput.value,
                "img": addAlbumImage.value
            }
            fetch(`http://localhost:8080/albums/addAlbum`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newAlbumJson)
            })
                .then(res => res.json())
                .then(newAlbum => {
                        makeHomeView(newAlbum);                       
                    });
        
        })
    }
}

function makeAlbumView(album) {
    // fetch("http://localhost:8080/albums/" + albumId)
    //     .then(res => res.json())
    //     .then(album => {
    console.log(album);
    containerEl.innerHTML = albumView(album);

    const songEl = containerEl.querySelectorAll(".album-songs")

    songEl.forEach(song => {
        let songIdEl = song.querySelector(".id_field");
        const deleteButton = song.querySelector(".delete-song-button");
        deleteButton.addEventListener("click", () => {
            fetch("http://localhost:8080/songs/" + songIdEl.value, {
                method: 'DELETE'
            })
                .then(res => res.json())
                .then(newAlbums => {
                    console.log(newAlbums)
                    newAlbums.forEach(newAlbum => {
                        if (newAlbum.id == album.id) {
                            makeAlbumView(newAlbum);
                        }
                    });
                })
        })

        const updateSongButton = song.querySelector(".update-song-button");
        updateSongButton.addEventListener("click", () => {
            console.log("clicked!");
            const updateSongName = song.querySelector(".update-song-name");
            fetch("http://localhost:8080/songs/" + songIdEl.value, {
                method: 'PATCH',
                body: updateSongName.value
            })
                .then(res => res.json())
                .then(newAlbums => {
                    console.log(newAlbums)
                    newAlbums.forEach(newAlbum => {
                        if (newAlbum.id == album.id) {
                            makeAlbumView(newAlbum);
                        }
                    });
                })
        })




        // })


        const addSongCommentBtn = song.querySelector(".addSongCommentBtn")
        const songrating = song.querySelector("#starRating")
        const songCommentInput = song.querySelector(".songCommentInput")
        if (songCommentInput != null) {
            addSongCommentBtn.addEventListener("click", () => {
                const newSongJson = {
                    "body": songCommentInput.value,
                    "rating": songrating.value
                }
                fetch(`http://localhost:8080/songs/${songIdEl.value}/addSongComment`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(newSongJson)
                })
                    .then(res => res.json())
                    .then(newAlbums => {
                        console.log(newAlbums)
                        newAlbums.forEach(newAlbum => {
                            if (newAlbum.id == album.id) {
                                makeAlbumView(newAlbum);
                            }
                        });
                    })
            })
        }
        


    })

    const backButton = containerEl.querySelector(".back-navigation");
    backButton.addEventListener("click", () => {
        makeHomeView();
    })

    const addSongBtn = containerEl.querySelector(".addSongButton");

    const songNameInput = containerEl.querySelector(".songNameInput");




    addSongBtn.addEventListener("click", () => {
        const newSongJson = {
            "name": songNameInput.value,
        }
        fetch(`http://localhost:8080/albums/${album.id}/addSong`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newSongJson)
        })
            .then(res => res.json())
            .then(album => {
                makeAlbumView(album);
            })
    })

    

    


    // })
}


makeHomeView();






//<h3 class="album-tech-stack">${album.song}</h3> dont think we will need this atleast not yet