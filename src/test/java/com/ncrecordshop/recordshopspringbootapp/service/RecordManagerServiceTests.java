package com.ncrecordshop.recordshopspringbootapp.service;


import com.ncrecordshop.recordshopspringbootapp.model.Album;

import com.ncrecordshop.recordshopspringbootapp.model.Genre;
import com.ncrecordshop.recordshopspringbootapp.repository.AlbumManagerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@DataJpaTest

public class RecordManagerServiceTests {

    @Mock
    private AlbumManagerRepository mockAlbumManagerRepository;

    @InjectMocks
    private AlbumManagerServiceImpl albumManagerServiceImpl;

    @Test
    @DisplayName("GET /albums/allalbums")
    public void testGetAllAlbumsReturnsListOfAlbums() {

        //Arrange
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1L, "Fall Out Boy", "From under the cork tree", 2005, Genre.ROCK));
        albums.add(new Album(2L, "Chappell Roan", "The Rise and Fall of the Midwest Princess", 2023, Genre.POP));
        albums.add(new Album(3L, "Eminem", "Encore", 2004, Genre.HipHop));

        when(mockAlbumManagerRepository.findAll()).thenReturn(albums);

        //Act
        List<Album> actualResult = albumManagerServiceImpl.getAllAlbums();

        //Assert
        assertThat(actualResult).hasSize(3);
        assertThat(actualResult).isEqualTo(albums);

    }

    @Test
    @DisplayName("GET /album/{id}")
    void testGetAlbumById() throws Exception {

        Album expectedResult = new Album(3L, "Eminem", "Encore", 2004, Genre.HipHop);

        when(mockAlbumManagerRepository.findById(expectedResult.getId())).thenReturn(Optional.of(expectedResult));

        Album actualResult = albumManagerServiceImpl.getAlbumById(expectedResult.getId());
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testForDeleteAlbum() {
        Long testId = 3L;
        Album testEminem = new Album(3L, "Eminem", "Encore", 2004, Genre.HipHop);

        when(mockAlbumManagerRepository.findById(testId)).thenReturn(Optional.of(testEminem));
        doNothing().when(mockAlbumManagerRepository).deleteById(testId);

        albumManagerServiceImpl.deleteAlbumById(testId);

        verify(mockAlbumManagerRepository, times(1)).deleteById(testId);
    }



//
//
//

//
//
//    @Test
//    @DisplayName("GET /albums/artist?name=")
//    void testGetAlbumsByArtist() throws Exception{
//
//        String name = "Fall Out Boy";
//
//        Artist fallOutBoy = Artist.builder().artistId(1L).name("Fall Out Boy").build();
//
//        List<Album> expected = List.of(
//                new Album(1L, "Fall Out Boy", "From under the cork tree", 2005, Genre.ROCK));
//
//
//        when(mockAlbumManagerRepository.findByArtistNameContainingIgnoreCase(name)).thenReturn(expected);
//
//        List<Album> actual = albumManagerServiceImpl.findByArtistNameContainingIgnoreCase(name);
//
//        assertIterableEquals(actual, expected);
//    }


    }



