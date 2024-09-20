package com.ncrecordshop.recordshopspringbootapp.repository;

import com.ncrecordshop.recordshopspringbootapp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArtistManagerRepository extends CrudRepository<Artist,Long> {
    Object getAllArtists();
}
