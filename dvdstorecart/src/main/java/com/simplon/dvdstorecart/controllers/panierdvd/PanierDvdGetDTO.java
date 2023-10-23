package com.simplon.dvdstorecart.controllers.panierdvd;

public record PanierDvdGetDTO(Long id, Long dvd_id, Long panier_id, Integer quantite, Float dvd_prix) {
}
