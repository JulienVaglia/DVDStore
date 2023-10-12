package com.simplon.dvdstorecart.controllers.paniers;

import java.util.Date;

public record PanierGetDTO(Long id, Float montant, Date date_validation, Long client_id, int quantity, Float price) {
}
