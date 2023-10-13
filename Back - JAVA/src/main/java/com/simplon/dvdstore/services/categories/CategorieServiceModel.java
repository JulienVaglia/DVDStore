package com.simplon.dvdstore.services.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * The type Categorie service model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieServiceModel {

    private Optional<Long> id;
    private String genre;

    /**
     * Instantiates a new Categorie service model.
     *
     * @param genre the genre
     */
    public CategorieServiceModel(String genre) {
        this.genre = genre;
    }
}
