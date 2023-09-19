package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;

import java.time.LocalDate;

public record VenteGetDTO (Long id, LocalDate date, DvdStoreGetDTO dvdStoreGetDTO, ClientGetDTO clientGetDTO, int quantity){

}
