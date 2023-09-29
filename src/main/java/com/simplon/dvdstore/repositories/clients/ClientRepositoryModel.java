package com.simplon.dvdstore.repositories.clients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // Génère un ID qui s'auto-incrémente pour chaque entrée
    private Long id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="adresse")
    private String adresse;


    public ClientRepositoryModel(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
}
