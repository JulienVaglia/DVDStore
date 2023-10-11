package com.simplon.dvdstore.controllers.dvd;

/**
 * The type Dvd store file dto.
 */
public record DvdStoreFileDTO (Long id, String name, String genre, Long quantity, Float price, String photo, String description) {
}
