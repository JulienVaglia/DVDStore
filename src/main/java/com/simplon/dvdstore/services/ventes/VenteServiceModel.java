package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
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
    private DvdServiceModel id_dvd;
    private ClientServiceModel id_client;


    public VenteServiceModel(Float montant, int quantity, DvdServiceModel id_dvd, ClientServiceModel id_client) {
        this.montant = montant;
        this.quantity = quantity;
        this.id_dvd = id_dvd;
        this.id_client = id_client;
    }
}
