// export default function albumView(album) {
//     return `
//     <li class="album-name" >${album.tit}</h2>
//     <ul>
//     ${album.songs.map(song => {
//         return `<li class="song-name">${song.songName}</li>`;
//     }).join("")
// }`
// }
export default function albumView(album) {
    console.log(album)
    return `
    <main class="main-content">
        <section class="album-library">
            <header class="album-library-header">
                <h2 class="album-library-title">${album.title}</h2>
                <img src="${album.img}" alt="Album Picture" width="400" height="400">
            </header>
                ${album.songs.map(song => {
            return `<section class="album-songs">
                    <h2 class="song-name">${song.name}</h2>
                    
                   <h3> ${
                        (song.comments != null) ? 
                    song.comments.map(comment => {
                    return `${comment.body}</h3 ><br>`;
                }).join("")
                : "" }
        
                    <input type="hidden" class="id_field" value="${song.id}" ></input>
                    <button class="delete-song-button">Delete</button>

                    <input type="text" placeholder="NewSongName" class="update-song-name"></input>
                    <button class="update-song-button">Update Song</button>

                    <div class="NewSongCommentDiv">
                <input type="text" placeholder="Song Comment"class="songCommentInput" class="id_field2"\>
                  <br>
                <button class="addSongCommentBtn">Add Song Comment</button>
            </div>
                    </section>`;
        }).join("")

        }
                
            <div class="NewSongDiv">
                <input type="text" placeholder="Song Name" class="songNameInput" \>
                  
                <button class="addSongButton">Add song</button>
            </div>
             
            <button class="back-navigation">back to album listings</button>
        </section >
    </main > `;
    
}