package com.simplon.dvdstore.repositories.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

/**
 * The type Vente repository model.
 */
@Entity
@Data
@Table(name = "vente")
@NoArgsConstructor
@AllArgsConstructor
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "montant")
    private Float montant;

    @ManyToOne
    @JoinColumn(name = "dvdstore_id")
    private DvdRepositoryModel dvdRepositoryModel;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientRepositoryModel clientRepositoryModel;

    @Column(name = "quantity")
    private int quantity;


    /**
     * Instantiates a new Vente repository model.
     *
     * @param date                  the date
     * @param montant               the montant
     * @param dvdRepositoryModel    the dvd repository model
     * @param clientRepositoryModel the client repository model
     * @param quantity              the quantity
     */
    public VenteRepositoryModel(LocalDate date, Float montant, DvdRepositoryModel dvdRepositoryModel, ClientRepositoryModel clientRepositoryModel, int quantity) {
        this.date = date;
        this.montant = montant;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.clientRepositoryModel = clientRepositoryModel;
        this.quantity = quantity;
    }
}
