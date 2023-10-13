package com.simplon.dvdstorecart.repositories.paniers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="panier")
@Data
@NoArgsConstructor
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

}
