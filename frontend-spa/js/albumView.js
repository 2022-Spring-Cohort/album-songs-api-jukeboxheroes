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
    return `
    <main class="main-content">
        <section class="album-library">
            <header class="album-library-header">
                <h2 class="album-library-header__title">${album.title}</h2>
                 ${
        album.comments.map(comment => {
            return `<h3 class="comment-name">${comment.body}</h3>`;
        }).join("")
    }
            </header>
                ${
                    album.songs.map(song => {
                    return `<section class="album-songs">
                    <h2 class="song-name">${song.name}</h2>
                    ${
                    song.comments.map(comment => {
            return `${ comment.body }</h3 >`;
                    }).join("")
                }
                    <input type="hidden" class="id_field" value="${song.id}" ></input>
                    <button class="delete-song-button">Delete</button>

                    <input type="text" placeholder="NewSongName" class="update-song-name"></input>
                    <button class="update-song-button">Update Song</button>

                    <div class="NewSongCommentDiv">
                <input type="text" placeholder="Song Comment" class="songCommentInput" class="id_field2"\>
                  
                <button class="addSongCommentBtn">Add Song Comment</button>
            </div>
                    </section>`;

              
                }).join("")
        }
                
            <div class="NewSongDiv">
                <input type="text" placeholder="Song Name" class="songNameInput" \>
                  
                <button class="addSongButton">Add song</button>
            </div>
             
            <a class="back-navigation">back to album listings</a>
        </section>
    </main>`;
    
}