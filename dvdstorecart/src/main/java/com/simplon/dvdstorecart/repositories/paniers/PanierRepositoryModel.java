package com.simplon.dvdstorecart.repositories.paniers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="panier")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PanierRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // Génère un ID qui s'auto-incrémente pour chaque entrée
    private Long id;
    @Column(name="montant")
    private Float montant;
    @Column(name="date_validation")
    private Date date_validation;
    @Column(name="client_id")
    private Long client_id;
    @Column(name="quantity")
    private int quantity;
    @Column(name = "price")
    private Float price;

    public PanierRepositoryModel(Float montant, Date date_validation, Long client_id, int quantity, Float price) {
        this.montant = montant;
        this.date_validation = date_validation;
        this.client_id = client_id;
        this.quantity = quantity;
        this.price = price;
    }
}
