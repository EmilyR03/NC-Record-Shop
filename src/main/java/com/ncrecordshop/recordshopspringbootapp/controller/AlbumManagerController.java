package com.ncrecordshop.recordshopspringbootapp.controller;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.service.AlbumManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/album")

public class AlbumManagerController {

    @Autowired
    AlbumManagerService albumManagerService;

    @GetMapping ("/allalbums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumManagerService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }


}
