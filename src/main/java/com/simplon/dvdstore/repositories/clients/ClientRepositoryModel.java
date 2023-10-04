package com.simplon.dvdstore.repositories.clients;

import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "clientRepositoryModel", orphanRemoval = true)
    private Set<VenteRepositoryModel> venteRepositoryModels = new LinkedHashSet<>();

    public void setVenteRepositoryModels(Set<VenteRepositoryModel> venteRepositoryModels) {
        this.venteRepositoryModels = venteRepositoryModels;
    }

    public ClientRepositoryModel(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public ClientRepositoryModel(Long id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
}
