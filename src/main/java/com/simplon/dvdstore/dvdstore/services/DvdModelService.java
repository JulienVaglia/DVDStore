package com.simplon.dvdstore.dvdstore.services;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdModelService {

    private String name;

    private String genre;

    public DvdModelService(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
