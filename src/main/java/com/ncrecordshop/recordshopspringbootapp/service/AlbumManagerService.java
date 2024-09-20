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
 //   Album insertAlbum(Album album);
    void deleteAlbumById(Long id);
 //   List<Album> getByQuantityInStock(int quantity);
    List<Album> getAllAlbumsByGenre(Genre genre);

    //void deleteAlbumById(Long id);
    //  void deleteAlbum(Long id);

    //  List<Album> findByArtistNameContainingIgnoreCase(String name);
}
