package com.ncrecordshop.recordshopspringbootapp.controller;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.service.AlbumManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/album")

public class AlbumManagerController {

    @Autowired
    AlbumManagerService albumManagerService;

    @GetMapping("/allalbums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumManagerService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumManagerService.getAlbumById(id);
        try {
            album= albumManagerService.getAlbumById(id);
        } catch (HttpServerErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");

        }
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumManagerService.addAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
//        Album newAlbum = albumManagerService.insertAlbum(album);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("album", "/api/v1/album/" + newAlbum.getId().toString());
//        return new ResponseEntity<>(newAlbum, httpHeaders, HttpStatus.CREATED);
    }

}
