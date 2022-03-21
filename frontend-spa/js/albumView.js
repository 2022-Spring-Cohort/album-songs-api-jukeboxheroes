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
            </header>
            <section class="album-songs">
                ${album.songs.map(song => {
                    return `<li class="song-name">${song.songName}</li>`;
                }).join("")
        }
                
            </section>
            <div class="NewSongDiv">
                <input type="text" placeholder="Song Name" class="songNameInput" \>
                  
                <button class="addSongButton">Add song</button>
            </div>
            <a class="back-navigation">back to album listings</a>
        </section>
    </main>`;
}