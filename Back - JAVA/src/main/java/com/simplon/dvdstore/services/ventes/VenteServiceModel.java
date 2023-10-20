package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

/**
 * The type Vente service model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModel {

    private Optional<Long> id;
    private LocalDate date;
    private Float montant;
    private int quantity;
    private DvdServiceModel dvd;
    private ClientServiceModel client;
    private Long id_dvd;
    private Long id_client;

    /**
     * Instantiates a new Vente service model.
     *
     * @param id       the id
     * @param date     the date
     * @param montant  the montant
     * @param quantity the quantity
     * @param dvd      the dvd
     * @param client   the client
     */
    public VenteServiceModel(Optional<Long> id, LocalDate date, Float montant, int quantity, DvdServiceModel dvd, ClientServiceModel client) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.quantity = quantity;
        this.dvd = dvd;
        this.client = client;
    }

    /**
     * Instantiates a new Vente service model.
     *
     * @param id        the id
     * @param date      the date
     * @param montant   the montant
     * @param quantity  the quantity
     * @param id_dvd    the id dvd
     * @param id_client the id client
     */
    public VenteServiceModel(Optional<Long> id, LocalDate date, Float montant, int quantity, Long id_dvd, Long id_client) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.quantity = quantity;
        this.id_dvd = id_dvd;
        this.id_client = id_client;
    }

    /**
     * Instantiates a new Vente service model.
     *
     * @param date     the date
     * @param montant  the montant
     * @param quantity the quantity
     * @param dvd      the dvd
     * @param client   the client
     */
    public VenteServiceModel(LocalDate date, Float montant, int quantity, DvdServiceModel dvd, ClientServiceModel client) {
        this.date = date;
        this.montant = montant;
        this.quantity = quantity;
        this.dvd = dvd;
        this.client = client;
    }
}
