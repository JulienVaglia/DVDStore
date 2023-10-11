package com.simplon.dvdstore.controllers.ventes;

import java.time.LocalDate;
import java.util.Date;

/**
 * The type Vente dto.
 */
public record VenteDTO (LocalDate date, Float montant, Long id_dvd, Long id_client, int quantity) {



}
