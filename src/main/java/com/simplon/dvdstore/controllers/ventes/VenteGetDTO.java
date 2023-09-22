package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;

import java.time.LocalDate;
import java.util.Date;

public record VenteGetDTO (Long id, Date date, Float montant,int quantity, DvdStoreGetDTO dvdStoreGetDTO, ClientGetDTO clientGetDTO){

}
