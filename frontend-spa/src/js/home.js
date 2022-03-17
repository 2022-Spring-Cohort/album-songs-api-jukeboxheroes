export default function home(albums) {
    return `
${albums.map(album => {
        return `
    <li class="list-item" >${album.albumName}</h2>
    <input type="hidden" class="id_field" value="${album.id}" >`
    }).join("")
        }    
`
}