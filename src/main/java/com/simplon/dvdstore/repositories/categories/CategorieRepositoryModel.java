package com.simplon.dvdstore.repositories.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The type Categorie repository model.
 */
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

    /**
     * Instantiates a new Categorie repository model.
     *
     * @param genre the genre
     */
    public CategorieRepositoryModel(String genre) {
        this.genre = genre;
    }
}
