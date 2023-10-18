package com.simplon.dvdstorecart.repositories.paniers;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="panier_dvd")
@Data
@NoArgsConstructor
public class PanierDvdRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // Génère un ID qui s'auto-incrémente pour chaque entrée
    private Long id;
    @Column(name="dvd_id")
    private Long dvd_id;
    @Column(name="panier_id")
    private Long panier_id;
    @Column(name="quantite")
    private Integer quantite;
    @Column(name = "dvd_prix")
    private Float dvd_prix;



}
