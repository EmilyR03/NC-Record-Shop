package com.ncrecordshop.recordshopspringbootapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncrecordshop.recordshopspringbootapp.model.Album;
import com.ncrecordshop.recordshopspringbootapp.model.Genre;
import com.ncrecordshop.recordshopspringbootapp.service.AlbumManagerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest

public class AlbumManagerControllerTests {

    @Mock
    private AlbumManagerServiceImpl mockAlbumManagerServiceImpl;

    @InjectMocks
    private AlbumManagerController albumManagerController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(albumManagerController).build();
        mapper = new ObjectMapper();
    }

    public List<Album> populateAlbums(){
        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album(1L, "Fall Out Boy", "From under the cork tree", 2005, Genre.ROCK));
        albumList.add(new Album(2L, "Chappell Roan", "The Rise and Fall of the Midwest Princess", 2023, Genre.POP));
        albumList.add(new Album(3L, "Eminem", "Encore", 2004, Genre.HipHop));
        albumList.add(new Album(4L, "Cher", "Believe", 1998, Genre.POP));
        albumList.add(new Album(5L, "Blink182", "Buddha", 1994, Genre.ROCK));
        albumList.add(new Album(6L, "Spice Girls", "Spice", 1996, Genre.POP));
        albumList.add(new Album(7L, "Pink Floyd", "Wish You Were Here", 1975, Genre.ROCK));

        return albumList;
    }

    @Test
    @DisplayName("get all albums")
    public void testGetAllAlbumsReturnAlbums() throws Exception {

        List<Album> albums = populateAlbums();

        when(mockAlbumManagerServiceImpl.getAllAlbums()).thenReturn(albums);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/album/allalbums"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artist").value("Fall Out Boy"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artist").value("Chappell Roan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].artist").value("Eminem"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].artist").value("Cher"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].id").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].artist").value("Blink182"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[5].id").value(6))
                .andExpect(MockMvcResultMatchers.jsonPath("$[5].artist").value("Spice Girls"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[6].id").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$[6].artist").value("Pink Floyd"));
    }

    @Test
    @DisplayName("get album by id")
    public void testGetAlbumById() throws  Exception {


    }


}
