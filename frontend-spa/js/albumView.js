export default function albumView(album) {
    console.log(album)
    return `
        <section class="album-library">
                <h2 class="album-title">${album.title}</h2>
                <img src="${album.img}" alt="Album Picture" width="400" height="400">
            
                ${album.songs.map(song => {
            return `<section class="album-songs">
                    <h3 class="song-name">${song.name}</h3>
                    
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
     `;
    
}