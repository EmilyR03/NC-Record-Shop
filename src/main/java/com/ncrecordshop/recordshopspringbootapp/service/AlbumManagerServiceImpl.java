package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
