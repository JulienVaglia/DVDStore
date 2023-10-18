package com.simplon.dvdstorecart.services.paniers;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PanierDvdServiceModel {

    private Long id;
    private Long dvd_id;;
    private Long panier_id;
    private Integer quantite;
    private Float dvd_prix;

}
