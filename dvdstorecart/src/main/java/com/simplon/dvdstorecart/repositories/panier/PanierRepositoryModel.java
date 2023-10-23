package com.simplon.dvdstorecart.repositories.panier;

import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name="panier")
@Data
@NoArgsConstructor
public class PanierRepositoryModel {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO) // Génère un ID qui s'auto-incrémente pour chaque entrée
        private Long id;
        @Column(name="montant", columnDefinition = "real")
        private Float montant;
        @Column(name="date_validation", columnDefinition = "date")
        private Date date_validation;
        @Column(name="client_id")
        private Long client_id;

        @OneToMany(mappedBy = "panierRepositoryModel", orphanRemoval = true)
        public List<PanierDvdRepositoryModel> dvds;

}

