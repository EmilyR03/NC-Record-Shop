package com.ncrecordshop.recordshopspringbootapp.repository;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumManagerRepository extends CrudRepository<Album, Long> {

 List<Album> findAllAlbumsByGenre(Genre genre);
//    Album findAlbumById(Long albumId);
//    List<Album> findByQuantityInStockGreaterThan(int quantityInStock);


  //  void deleteAlbumById(Long id);

  //  List<Album> findByArtistNameContainingIgnoreCase(String name);

}
