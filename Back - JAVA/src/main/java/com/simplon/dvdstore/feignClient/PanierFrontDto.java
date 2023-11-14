package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;

import java.util.Date;
import java.util.List;

public record PanierFrontDto(Long id,
                             Float montant,
                             Date date_validation,
                             ClientGetDTO client,
                             List<PanierDvdDto> dvds) {
}
