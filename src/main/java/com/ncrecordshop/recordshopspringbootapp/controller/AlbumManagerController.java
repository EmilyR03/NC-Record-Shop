package com.ncrecordshop.recordshopspringbootapp.controller;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.model.Genre;
import com.ncrecordshop.recordshopspringbootapp.service.AlbumManagerService;
//import com.ncrecordshop.recordshopspringbootapp.service.ArtistManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/album")

public class AlbumManagerController {

    @Autowired
    AlbumManagerService albumManagerService;

//    @Autowired
//    ArtistManagerService artistManagerService;

    @GetMapping("/allalbums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumManagerService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumManagerService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumManagerService.addAlbum(album);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("album", "/api/v1/album" + newAlbum.getId().toString());
        return new ResponseEntity<>(newAlbum, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album updatedAlbum) {
        Album updated = albumManagerService.updateAlbum(id, updatedAlbum);
        HttpHeaders httpHeaders1 = new HttpHeaders();
        httpHeaders1.add("album", "/api/v1/album/update" + updated.getId().toString());
        return new ResponseEntity<>(updated, httpHeaders1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbumById(@PathVariable Long id) {
        albumManagerService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Album>> getAllAlbumsByGenre(@PathVariable Genre genre) {
        List<Album> albums = albumManagerService.getAllAlbumsByGenre(genre);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }


    @GetMapping("/year/{year}")
    public ResponseEntity<List<Album>> getAlbumsByYear(@PathVariable int year) {
        List<Album> albums = albumManagerService.getByReleaseYear(year);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }


}

//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Album> deleteAlbumById(@PathVariable Long id){
//        albumManagerService.deleteAlbumById(id);
//        return ResponseEntity.noContent().build();
//    }

