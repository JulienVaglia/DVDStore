package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModel {

    private Optional<Long> id;
    private Date date;
    private Float montant;
    private int quantity;
    private Long id_dvd;
    private Long id_client;

//    public VenteServiceModel(Float montant, Long id_dvd, Long id_client, int quantity) {
//        this.montant = montant;
//        this.id_dvd = id_dvd;
//        this.id_client = id_client;
//        this.quantity = quantity;
//    }

    public VenteServiceModel(Float montant, int quantity, Long id_dvd, Long id_client) {
        this.montant = montant;
        this.quantity = quantity;
        this.id_dvd = id_dvd;
        this.id_client = id_client;
    }
}
