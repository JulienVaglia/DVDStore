package com.simplon.dvdstore.controllers.dvd;

public record DvdStoreFileDTO (Long id, String name, String genre, Long quantity, Float price, String photo, String description) {
}
