package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Album;

import java.awt.print.Book;
import java.util.List;

public interface AlbumManagerService {

    List<Album> getAllAlbums();
    Album getAlbumById(Long id);
    Album addAlbum(Album album);
}
