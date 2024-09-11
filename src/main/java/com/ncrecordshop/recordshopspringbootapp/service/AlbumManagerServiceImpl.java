package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

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
        return albumManagerRepository.findById(id).get();
    }

    @Override
    public Album addAlbum(Album album) {
        return albumManagerRepository.save(album);
    }

    @Override
    public Album updateAlbumById(Long id, Album updatedAlbum) {
        Album currentAlbum = getAlbumById(id);

        currentAlbum.setArtist(updatedAlbum.getArtist());
        currentAlbum.setAlbum(updatedAlbum.getAlbum());
        currentAlbum.setReleaseYear(updatedAlbum.getReleaseYear());
        currentAlbum.setGenre(updatedAlbum.getGenre());

        return albumManagerRepository.save(currentAlbum);

    }


}
