package com.ncrecordshop.recordshopspringbootapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Album")

public class Album {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String artist;

    @Column
    String album;

    @Column
    int releaseYear;

    @Column
    Genre genre;



}
