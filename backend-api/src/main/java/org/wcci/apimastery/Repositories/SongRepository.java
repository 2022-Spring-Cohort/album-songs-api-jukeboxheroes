package org.wcci.apimastery.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Entities.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    Optional<Song> findByNameIgnoreCase(String name);
}