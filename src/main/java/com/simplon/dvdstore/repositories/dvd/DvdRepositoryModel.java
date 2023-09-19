package com.simplon.dvdstore.repositories.dvd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;


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

    public DvdRepositoryModel(String name, String genre, Long quantity, Float price)
        {
            this.name = name;
            this.genre = genre;
            this.quantity = quantity;
            this.price = price;
        }
}
