package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModel {

    //(Long id, LocalDate date, Float montant, String nom, String prenom, String product, int quantity)

    private Optional<Long> id;
    private Date date;
    private Float montant;
    private DvdStoreGetDTO dvdStoreGetDTO;
    private ClientGetDTO clientGetDTO;
    private int quantity;
//    private String nom;
//    private String prenom;
//    private String product;


    public VenteServiceModel(Float montant, DvdStoreGetDTO dvdStoreGetDTO, ClientGetDTO clientGetDTO, int quantity) {
        this.montant = montant;
        this.dvdStoreGetDTO = dvdStoreGetDTO;
        this.clientGetDTO = clientGetDTO;
        this.quantity = quantity;
    }
}
