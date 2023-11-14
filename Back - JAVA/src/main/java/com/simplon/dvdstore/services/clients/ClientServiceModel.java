package com.simplon.dvdstore.services.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * The type Client service model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientServiceModel {

    private Optional<Long> id;
    private String nom;
    private String prenom;
    private String adresse;

    /**
     * Instantiates a new Client service model.
     *
     * @param nom     the nom
     * @param prenom  the prenom
     * @param adresse the adresse
     */
    public ClientServiceModel(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }




}
