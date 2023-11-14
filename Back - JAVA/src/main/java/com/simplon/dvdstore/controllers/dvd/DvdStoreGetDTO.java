package com.simplon.dvdstore.controllers.dvd;

/**
 * The type Dvd store get dto.
 */
public record DvdStoreGetDTO(Long id, String name, String genre, Long quantity, Float price, String photo, String description) {

}
