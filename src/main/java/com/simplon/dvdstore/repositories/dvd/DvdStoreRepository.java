package com.simplon.dvdstore.repositories.dvd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

/**
 * The interface Dvd store repository.
 */
@Repository
public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel,Long>{


    ArrayList<DvdRepositoryModel> findAll();



}
