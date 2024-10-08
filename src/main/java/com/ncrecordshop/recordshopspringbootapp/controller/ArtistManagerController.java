//package com.ncrecordshop.recordshopspringbootapp.controller;
//
//import com.ncrecordshop.recordshopspringbootapp.model.Artist;
//import com.ncrecordshop.recordshopspringbootapp.service.ArtistManagerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/artist")
//
//public class ArtistManagerController {
//
//    @Autowired
//    ArtistManagerService artistManagerService;
//
//

//    list all albums by a given artist
//    list all albums by a given release year
//    list all albums by a given genre
//    get album information by album name
//
//    @GetMapping
//    public ResponseEntity<List<Artist>> getAllArtists() {
//        return new ResponseEntity<>(artistManagerService.getAllArtists(), HttpStatus.OK);
//    }


//}
