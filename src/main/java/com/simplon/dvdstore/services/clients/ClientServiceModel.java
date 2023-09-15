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
    private String addresse;

    public ClientServiceModel(String nom, String prenom, String addresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
    }
}
