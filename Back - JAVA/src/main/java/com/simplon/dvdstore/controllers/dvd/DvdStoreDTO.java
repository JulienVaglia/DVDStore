package com.simplon.dvdstore.controllers.dvd;


/**
 * The type Dvd store dto.
 */
public record DvdStoreDTO(String name, String genre, Long quantity, Float price, String photo, String description) { }

