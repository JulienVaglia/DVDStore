package com.simplon.dvdstorecart.services.paniers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
public class PanierServiceModel {

    private Long id;
    private Float montant;
    private Date date_validation;
    private Long client_id;
    private int quantity;
    private Float price;

}
