package com.simplon.dvdstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type Not found exection.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExection extends ResponseStatusException {

    /**
     * Instantiates a new Not found exection.
     *
     * @param id the id
     */
    public NotFoundExection ( Long id)
        {
            super(HttpStatus.NOT_FOUND, "DVD introuvable avec l'ID : " + id);
        }

}
