package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;

import java.time.LocalDate;

public record VenteDTO (Float montant, DvdStoreGetDTO dvdStoreGetDTO, ClientGetDTO clientGetDTO, int quantity) {


}
