package com.simplon.dvdstore.services.dvd;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * The type Dvd service model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdServiceModel {

        private Optional<Long> id;
        private String name;
        private String genre;
        private Long quantity;
        private Float price;
        private String photo;
        private String description;


    /**
     * Instantiates a new Dvd service model.
     *
     * @param name        the name
     * @param genre       the genre
     * @param quantity    the quantity
     * @param price       the price
     * @param photo       the photo
     * @param description the description
     */
    public DvdServiceModel(String name, String genre, Long quantity, Float price, String photo, String description) {
                this.name = name;
                this.genre = genre;
                this.quantity = quantity;
                this.price = price;
                this.photo = photo;
                this.description = description;
        }
}
