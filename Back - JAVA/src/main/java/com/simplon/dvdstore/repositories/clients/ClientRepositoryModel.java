package com.simplon.dvdstore.repositories.clients;

import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Client repository model.
 */
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

    /**
     * Sets vente repository models.
     *
     * @param venteRepositoryModels the vente repository models
     */
    public void setVenteRepositoryModels(Set<VenteRepositoryModel> venteRepositoryModels) {
        this.venteRepositoryModels = venteRepositoryModels;
    }

    /**
     * Instantiates a new Client repository model.
     *
     * @param nom     the nom
     * @param prenom  the prenom
     * @param adresse the adresse
     */
    public ClientRepositoryModel(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    /**
     * Instantiates a new Client repository model.
     *
     * @param id      the id
     * @param nom     the nom
     * @param prenom  the prenom
     * @param adresse the adresse
     */
    public ClientRepositoryModel(Long id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
}
