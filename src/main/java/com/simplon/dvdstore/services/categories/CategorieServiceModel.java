package com.simplon.dvdstore.services.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieServiceModel {

    private Optional<Long> id;
    private String genre;

    public CategorieServiceModel(String genre) {
        this.genre = genre;
    }
}
