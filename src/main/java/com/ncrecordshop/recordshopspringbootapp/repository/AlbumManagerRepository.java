package com.ncrecordshop.recordshopspringbootapp.repository;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumManagerRepository extends CrudRepository<Album, Long> {


    void deleteAlbumById(Long id);
}
