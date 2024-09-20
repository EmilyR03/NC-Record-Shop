package com.ncrecordshop.recordshopspringbootapp.controller;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.service.AlbumManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/album/")

public class AlbumManagerController {

    @Autowired
    AlbumManagerService albumManagerService;

    @GetMapping("allalbums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumManagerService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumManagerService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumManagerService.insertAlbum(album);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("album", "/api/v1/album" + newAlbum.getId().toString());
        return new ResponseEntity<>(newAlbum, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album updatedAlbum) {
        Album updated = albumManagerService.updateAlbumById(id, updatedAlbum);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Album> deleteAlbumById(@PathVariable Long id) {
        albumManagerService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/in-stock")
    public ResponseEntity<List<Album>> getAllAlbumsInStock() {
        List<Album> albums = albumManagerService.getByQuantityInStock(1);
        return new ResponseEntity<>(albums, HttpStatus.OK);

    }

}

//    @GetMapping("/artist")
//    public ResponseEntity<List<Album>> getAlbumsByArtist(@RequestParam(value = "name") String name) {
//        List<Album> album = albumManagerService.findByArtistNameContainingIgnoreCase(name);
//        return new ResponseEntity<>(album, HttpStatus.OK);
//        }


//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Album> deleteAlbumById(@PathVariable Long id){
//        albumManagerService.deleteAlbumById(id);
//        return ResponseEntity.noContent().build();
//    }

