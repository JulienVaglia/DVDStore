package com.simplon.dvdstorecart.services.panier;

import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import com.simplon.dvdstorecart.services.panierdvd.PanierDvdServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class PanierServiceModel {

    private Long id;
    private Float montant;
    private Date date_validation;
    private Long client_id;

    private List<PanierDvdServiceModel> dvds;

}
