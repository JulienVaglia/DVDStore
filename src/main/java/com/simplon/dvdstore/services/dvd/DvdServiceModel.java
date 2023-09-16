package com.simplon.dvdstore.services.dvd;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdServiceModel {

        private Optional<Long> id;
        private String name;
        private String genre;
        private Long quantity;

        public DvdServiceModel(String name, String genre) {
                this.name = name;
                this.genre = genre;
        }

        public DvdServiceModel(String name, String genre, Long quantity) {
                this.name = name;
                this.genre = genre;
                this.quantity = quantity;
        }
}