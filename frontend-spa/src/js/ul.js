export default function home(campuses) {
    return `
<main class="main-content">
<section class="album-list">
${albums.map(album => {
        return `<div class="album">
    <h2 class="album-name" >${album.albumName}</h2>
    <input type="hidden" class="id_field" value="${album.id}" >
    
</div>`
    }).join("")
        }    

</section>
</main>
`
}