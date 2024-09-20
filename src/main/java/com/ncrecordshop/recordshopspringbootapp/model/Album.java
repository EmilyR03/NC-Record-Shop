package com.ncrecordshop.recordshopspringbootapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="Album")

public class Album {

    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    Long id;

   // @ManyToOne()
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
