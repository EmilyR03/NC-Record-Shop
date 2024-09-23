package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.model.Genre;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface AlbumManagerService {

    List<Album> getAllAlbums();
    Album getAlbumById(Long id);
    Album addAlbum(Album album);
    Album updateAlbumById(Long id, Album album);
    void deleteAlbumById(Long id);
    List<Album> getByReleaseYear(int year);
    List<Album> getAllAlbumsByGenre(Genre genre);
//    List<Album> getByQuantityInStock(int quantity);


    //
    //    @Override
    //    public List<Album> getByQuantityInStock(int quantity) {
    //        return albumManagerRepository.findByQuantityInStockGreaterThan(quantity);
    //    }
    //
    List<Album> getByGenre(Genre genre);

    //
//    List<Album> getByGenre(Genre genre);
//



    //void deleteAlbumById(Long id);
    //  void deleteAlbum(Long id);
    //   Album insertAlbum(Album album);
    //  List<Album> findByArtistNameContainingIgnoreCase(String name);
}
