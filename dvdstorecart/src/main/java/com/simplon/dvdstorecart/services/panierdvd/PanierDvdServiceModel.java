package com.simplon.dvdstorecart.services.panierdvd;


import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PanierDvdServiceModel {

    private Long id;
    private Long dvd_id;;
    private Long panier_id;
    private Float dvd_prix;
    private Integer quantite;

//    private PanierRepositoryModel panierRepositoryModel;
}
