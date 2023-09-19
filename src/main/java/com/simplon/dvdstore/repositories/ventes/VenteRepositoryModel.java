package com.simplon.dvdstore.repositories.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
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

    @OneToMany
    @JoinColumn(name = "dvdstore_id")
    private List<DvdStoreGetDTO> dvdStoreGetDTOList;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private List<ClientGetDTO> clientGetDTOList;



    @Column(name = "quantity")
    private int quantity;
//    @Column(name = "nom")
//    private String nom;
//    @Column(name = "prenom")
//    private String prenom;
//    @Column(name = "product")
//    private String product;


    public VenteRepositoryModel(Float montant, List<DvdStoreGetDTO> dvdStoreGetDTOList, List<ClientGetDTO> clientGetDTOList, int quantity) {
        this.montant = montant;
        this.dvdStoreGetDTOList = dvdStoreGetDTOList;
        this.clientGetDTOList = clientGetDTOList;
        this.quantity = quantity;
    }

}
