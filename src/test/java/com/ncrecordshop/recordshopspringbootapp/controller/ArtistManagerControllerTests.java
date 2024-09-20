package com.ncrecordshop.recordshopspringbootapp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncrecordshop.recordshopspringbootapp.model.Artist;
import com.ncrecordshop.recordshopspringbootapp.repository.ArtistManagerRepository;
import com.ncrecordshop.recordshopspringbootapp.service.ArtistManagerServiceImpl;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class ArtistManagerControllerTests {

    @Mock
    private ArtistManagerServiceImpl mockArtistManagerServiceImpl;

    @InjectMocks
    private ArtistManagerController artistManagerController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(artistManagerController).build();
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("GET /artists")
    void testGetAllArtists() throws Exception {

        Artist blink182 = Artist.builder().artistId(1L).artistName("Blink182").build();
        Artist eminem = Artist.builder().artistId(2L).artistName("Eminem").build();

        List<Artist> expected = List.of(blink182, eminem);

        when(mockArtistManagerServiceImpl.getAllArtists()).thenReturn(expected);

        this.mockMvcController.perform(MockMvcRequestBuilders.get("/api/v1/artists"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistName").value("Blink182"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistName").value("Eminem"));

    }



}
