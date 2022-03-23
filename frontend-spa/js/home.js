export default function home(albums) {
    return `
<main class="main-content">
<section class="album-list">
${albums.map(album => {
        return `<div class="album">
        <h2 class="album-title" >${album.title}</h2>
        <img class="album-image" src="${album.img}" alt="Album Picture" width="200" height="200">
        <input type="hidden" class="id_field" value="${album.id}" >
        <div class="NewAlbumCommentDiv">
                <input type="text" placeholder="Album Comment" class="albumCommentInput" class="id_field2"\>
                  
                <button class="addAlbumCommentBtn">Add Album Comment</button>
            </div>
        <section class="album-songs">
            <h9 class="album-comment"> Comments:</h9> 
                ${
            album.comments.map(comment => {
                return `<h2 class="comment-body">${comment.body}</h2>`;
            }).join("")
        }
                
            </section>
        <button class="delete-button">Delete Album</button>
        <input type="text" class="update-title" placeholder="New Title"" />
        <button class="update-button">Update Title</button>
         <br>
        
    </div><br>`
     
    }).join("")
        }  
        <input type="text" class="add-album" placeholder= "New Album Title" />
        <button class="add-album-button">Add Album</button>
        </main>
`
}