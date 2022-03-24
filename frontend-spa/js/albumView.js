export default function albumView(album) {
    console.log(album)
    return `
        <section class="album-library">
                <h2 class="album-title">${album.title}</h2>
                <img src="${album.img}" alt="Album Picture" width="400" height="400">
            
                </header>
            
                ${album.songs.map(song => {
            return `<section class="album-songs">
                    <h2 class="song-name">${song.name}<br>${song.duration}</h2>
                    <iframe src="${song.video}" width="100%" height="380" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"></iframe>
                    ${
                        (song.comments != null) ? 
                    song.comments.map(comment => {
                    return `${comment.body}</h3 ><br>`;
                }).join("")
                : "" }
        
                    <input type="hidden" class="id_field" value="${song.id}" ></input>
                    <button class="delete-song-button">Delete Album</button>

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
            <footer class ="Record-Label">	&copy; ${album.recordLabel}
            </footer>
            </section >
     `;
    
}