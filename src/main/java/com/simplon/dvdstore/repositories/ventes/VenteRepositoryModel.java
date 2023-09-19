package com.simplon.dvdstore.repositories.ventes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "vente")
@NoArgsConstructor
@AllArgsConstructor
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "montant")
    private Float montant;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "product")
    private String product;
    @Column(name = "quantity")
    private int quantity;

    public VenteRepositoryModel(LocalDate date, Float montant, String nom, String prenom, String product, int quantity) {
        this.date = date;
        this.montant = montant;
        this.nom = nom;
        this.prenom = prenom;
        this.product = product;
        this.quantity = quantity;
    }
}
