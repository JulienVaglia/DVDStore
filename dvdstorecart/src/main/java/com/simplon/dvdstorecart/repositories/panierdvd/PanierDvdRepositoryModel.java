package com.simplon.dvdstorecart.repositories.panierdvd;

import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
//    @Column(name="panier_id")
//    private Long panier_id;
    @Column(name="quantite")
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "panier_id")
    private List<PanierRepositoryModel> panierRepositoryModel;




}
