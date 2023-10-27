package com.simplon.dvdstore.repositories.clients;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * The interface Client repository.
 */
@Repository
public interface ClientRepository extends CrudRepository<ClientRepositoryModel,Long> {

    ArrayList<ClientRepositoryModel> findAll();

}
