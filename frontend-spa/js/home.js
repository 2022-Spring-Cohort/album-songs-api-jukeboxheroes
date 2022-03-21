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
                return `<h3 class="song-name">${song.name}</h3>`;
            }).join("")
        }
                
            </section>
        <button class="delete-button">Delete</button>
        <input type="text" class="update-title" placeholder="New Title"" />
        <button class="update-button">Update Title</button>
     </div>`
    }).join("")
        }  
`
}