package com.simplon.dvdstorecart.controllers.paniers.panier;

import java.util.Date;

public record PanierDTO(Float montant, Date date_validation, Long client_id, int quantity, Float price) {
}
