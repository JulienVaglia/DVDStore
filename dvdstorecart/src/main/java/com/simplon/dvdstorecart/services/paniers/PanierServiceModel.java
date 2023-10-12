package com.simplon.dvdstorecart.services.paniers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierServiceModel {

    private Optional<Long> id;
    private Float montant;
    private Date date_validation;
    private Long client_id;
    private int quantity;
    private Float price;

    public PanierServiceModel(Float montant, Date date_validation, Long client_id, int quantity, Float price) {
        this.montant = montant;
        this.date_validation = date_validation;
        this.client_id = client_id;
        this.quantity = quantity;
        this.price = price;
    }
}
