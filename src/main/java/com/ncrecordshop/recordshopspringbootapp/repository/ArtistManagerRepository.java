package com.ncrecordshop.recordshopspringbootapp.repository;

import com.ncrecordshop.recordshopspringbootapp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistManagerRepository extends JpaRepository<Artist,Long> {
}
