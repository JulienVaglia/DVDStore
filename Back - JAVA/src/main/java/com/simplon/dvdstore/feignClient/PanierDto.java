package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;

import java.util.Date;
import java.util.List;

public record PanierDto(
        Long id,
        Float montant,
        Date date_validation,
        Long client_id,
        List<PanierDvdDto> dvds) {
}
