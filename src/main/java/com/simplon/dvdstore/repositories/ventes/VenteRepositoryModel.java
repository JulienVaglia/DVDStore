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

import java.util.Date;

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
    @CreationTimestamp
    private Date date;

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

    public VenteRepositoryModel(Float montant, DvdRepositoryModel dvdRepositoryModel, ClientRepositoryModel clientRepositoryModel, int quantity) {
        this.montant = montant;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.clientRepositoryModel = clientRepositoryModel;
        this.quantity = quantity;
    }

    public VenteRepositoryModel(Date date, Float montant, DvdRepositoryModel dvdRepositoryModel, ClientRepositoryModel clientRepositoryModel, int quantity) {
        this.date = date;
        this.montant = montant;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.clientRepositoryModel = clientRepositoryModel;
        this.quantity = quantity;
    }
}
