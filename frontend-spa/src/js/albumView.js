export default function albumView(album) {
    return `
    <li class="album-name" >${album.albumName}</h2>
    <ul>
    ${album.songs.map(song => {
        return `<li class="song-name">${song.songName}</li>`;
    }).join("")
}`
}