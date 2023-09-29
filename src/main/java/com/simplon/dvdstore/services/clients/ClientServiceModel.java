package com.simplon.dvdstore.services.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientServiceModel {

    private Optional<Long> id;
    private String nom;
    private String prenom;
    private String adresse;

    public ClientServiceModel(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }


}
