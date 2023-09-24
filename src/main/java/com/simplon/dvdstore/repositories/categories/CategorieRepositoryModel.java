package com.simplon.dvdstore.repositories.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categorie")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategorieRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "genre")
    private String genre;

    public CategorieRepositoryModel(String genre) {
        this.genre = genre;
    }
}
