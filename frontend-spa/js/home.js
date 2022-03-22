export default function home(albums) {
    return `
<main class="main-content">
<section class-"album-list">
${albums.map(album => {
        return `<div class="album">
        <h2 class="album-title" >${album.title}</h2>
        <input type="hidden" class="id_field" value="${album.id}" >
        <section class="album-songs">
                ${
            album.songs.map(song => {
                return `<h2 class="song-name">${song.name}</h2>`;
            }).join("")
        }
                
            </section>
        <button class="delete-button">Delete</button>
        <input type="text" class="update-title" placeholder="New Title"" />
        <button class="update-button">Update Title</button>


     </div>`
    }).join("")
        }  
        <input type="text" class="add-album" placeholder= "New Album Title" />
        <button class="add-album-button">Add Album</button>
        </main>
`
}