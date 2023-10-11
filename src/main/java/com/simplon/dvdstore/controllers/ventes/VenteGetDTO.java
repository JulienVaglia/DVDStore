package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;

import java.time.LocalDate;
import java.util.Date;

/**
 * The type Vente get dto.
 */
public record VenteGetDTO (Long id, LocalDate date, Float montant,int quantity, DvdStoreGetDTO dvdStoreGetDTO, ClientGetDTO clientGetDTO){

}
