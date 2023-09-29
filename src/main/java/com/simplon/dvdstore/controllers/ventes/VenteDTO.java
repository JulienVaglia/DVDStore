package com.simplon.dvdstore.controllers.ventes;

import java.util.Date;

public record VenteDTO (Date date, Float montant, Long id_dvd, Long id_client, int quantity) {



}
