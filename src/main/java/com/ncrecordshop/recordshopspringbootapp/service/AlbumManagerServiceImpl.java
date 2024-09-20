package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumManagerServiceImpl implements AlbumManagerService {

    @Autowired
    AlbumManagerRepository albumManagerRepository;


    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        albumManagerRepository.findAll().forEach(albums::add);
        return albums;
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumManagerRepository.findById(id).orElse(null);
    }

    @Override
    public Album addAlbum(Album album) {
        return albumManagerRepository.save(album);
    }


    @Override
    public Album updateAlbumById(Long id, Album updatedAlbum) {
        Album currentAlbum = getAlbumById(id);

        if (currentAlbum != null) {
            currentAlbum.setArtist(updatedAlbum.getArtist());
            currentAlbum.setAlbumName(updatedAlbum.getAlbumName());
            currentAlbum.setReleaseYear(updatedAlbum.getReleaseYear());
            currentAlbum.setGenre(updatedAlbum.getGenre());

            return albumManagerRepository.save(currentAlbum);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Album insertAlbum(Album album) {
        return albumManagerRepository.save(album);
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumManagerRepository.deleteById(id);
    }

    @Override
    public List<Album> getByQuantityInStock(int quantity) {
        return albumManagerRepository.findByQuantityInStockGreaterThan(quantity);
    }

}

//    @Override
//    public List<Album> findByArtistNameContainingIgnoreCase(String name) {
//        return albumManagerRepository.findByArtistNameContainingIgnoreCase(name);
//    }

//
//    @Override
//    public void deleteAlbumById(Long id) {
//        albumManagerRepository.deleteAlbumById(id);
//    }
//




//    @Override
  //  public Album insertAlbum(Album album) {
    //    return albumManagerRepository.save(album);





