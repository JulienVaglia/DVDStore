package com.simplon.dvdstore.repositories.dvd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;


/**
 * The type Dvd repository model.
 */
@Entity
@Table(name="dvdstore")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DvdRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
    @Column(name="quantity")
    private Long quantity;
    @Column(name = "price")
    private Float price;
    @Column(name = "photo")
    private String photo;
    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    /**
     * Instantiates a new Dvd repository model.
     *
     * @param name        the name
     * @param genre       the genre
     * @param quantity    the quantity
     * @param price       the price
     * @param photo       the photo
     * @param description the description
     */
    public DvdRepositoryModel(String name, String genre, Long quantity, Float price, String photo, String description)
        {
            this.name = name;
            this.genre = genre;
            this.quantity = quantity;
            this.price = price;
            this.photo = photo;
            this.description = description;
        }
}
