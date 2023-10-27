package com.simplon.dvdstore.feignClient;

public record PanierDvdDto(Long id,
                           Long dvd_id,
                           Integer quantite
                           ) {
}
