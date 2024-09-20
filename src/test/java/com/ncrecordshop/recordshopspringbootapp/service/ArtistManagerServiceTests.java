package com.ncrecordshop.recordshopspringbootapp.service;

import com.ncrecordshop.recordshopspringbootapp.model.Artist;
import com.ncrecordshop.recordshopspringbootapp.repository.ArtistManagerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

public class ArtistManagerServiceTests {

    @Mock
    private ArtistManagerRepository mockArtistManagerRepository;

    @InjectMocks
    private ArtistManagerServiceImpl artistManagerServiceImpl;

//    @Test
//    @DisplayName("GET /artists")
//    void getAllArtists() throws NullPointerException {
//
//        Artist blink182 = Artist.builder().artistId(1L).artistName("Blink182").build();
//        Artist eminem = Artist.builder().artistId(2L).artistName("Eminem").build();
//
//        List<Artist> expected = List.of(blink182, eminem);
//
//        when(mockArtistManagerRepository.getAllArtists()).thenReturn(expected);
//
//        List<Artist> actual = artistManagerServiceImpl.getAllArtists();
//
//        assertIterableEquals(actual, expected);
//    }


}
