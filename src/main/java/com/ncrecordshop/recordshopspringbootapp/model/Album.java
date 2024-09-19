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
   @GeneratedValue//(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String artist;

    @Column
    String albumName;

    @Column
            //date format to that
    int releaseYear;

    @Column
    @Enumerated(EnumType.STRING)
    Genre genre;


}
