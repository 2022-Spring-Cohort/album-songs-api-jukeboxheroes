export default function home(albums) {
    return `

${albums.map(album => {
        return `<div class="album">
        <h2 class="album-title" >${album.title}</h2>
        <input type="hidden" class="id_field" value="${album.id}" >
        <button class="delete-button">Delete</button>
        <button class="update-button">Update Songs</button>
     </div>`
    }).join("")
        }  
`
}