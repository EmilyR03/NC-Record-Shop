package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Artist;
import com.ncrecordshop.recordshopspringbootapp.repository.ArtistManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ArtistManagerServiceImpl implements ArtistManagerService {

    @Autowired
    ArtistManagerRepository artistManagerRepository;

    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        artistManagerRepository.findAll().forEach(artists::add);
        return artists;
    }
}
