package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "dvdstore")
public class DvdModel {


// Propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;

    public DvdModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
