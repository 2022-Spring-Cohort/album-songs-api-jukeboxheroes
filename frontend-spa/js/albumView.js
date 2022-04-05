export default function albumView(album) {
  console.log(album);
  return `
        <section class="album-library">
            <div style="text-align: center;">
                <h2 class="album-title">${album.title}</h2>
                
                <img src="${
                  album.img
                }" alt="Album Picture" width="400" height="400">
                </div>
                

                ${album.songs
                  .map((song) => {
                    return `<section class="album-songs">
                    <h2 class="song-name">${song.name}<br>${song.duration}</h2>
                    <h3>Average Rating: <img src ="images/star${
                      song.rating
                    }.png"</h3>
                    <iframe src="${
                      song.video
                    }" width="100%" height="380" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"></iframe>
                    ${
                      song.comments != null
                        ? song.comments
                            .map((comment) => {
                              return `${comment.body} <img src ="images/star${comment.rating}.png"</h3 ><br>`;
                            })
                            .join("")
                        : ""
                    }
        
                    <input type="hidden" class="id_field" value="${
                      song.id
                    }" ></input>
                    <button class="delete-song-button">Delete Album</button>

                    <input type="text" placeholder="NewSongName" class="update-song-name"></input>
                    <button class="update-song-button">Update Song</button>

                    <div class="NewSongCommentDiv">
                <input type="text" placeholder="Song Comment"class="songCommentInput" class="id_field2"\>
                <input type="number" min="1" max="5" id="starRating" name="starRating" value="3" placeholder="4 star truck!">
                <br>         
                <button class="addSongCommentBtn">Add Song Comment</button>
                
            </div>
                    </section>`;
                  })
                  .join("")}
                
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
