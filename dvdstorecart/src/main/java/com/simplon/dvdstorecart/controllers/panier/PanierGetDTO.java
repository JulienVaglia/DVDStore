package com.simplon.dvdstorecart.controllers.panier;

import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;

import java.util.Date;
import java.util.List;


public record PanierGetDTO(Long id, Float montant, Date date_validation, Long client_id, List<PanierDvdRepositoryModel> dvds) {
}
