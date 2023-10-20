package com.simplon.dvdstore.repositories.ventes;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * The interface Vente repository.
 */
public interface VenteRepository extends CrudRepository<VenteRepositoryModel, Long> {

    ArrayList<VenteRepositoryModel> findAll();


}
