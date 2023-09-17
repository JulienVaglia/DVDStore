package com.simplon.dvdstore.repositories.ventes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vente")
@NoArgsConstructor
@AllArgsConstructor
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    LocalDate date;
    @Column(name = "price")
    Float price;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;

    public VenteRepositoryModel(LocalDate date, Float price, String nom, String prenom) {
        this.date = date;
        this.price = price;
        this.nom = nom;
        this.prenom = prenom;
    }
}
