package com.simplon.dvdstore.dvdstore.repositories;

import com.simplon.dvdstore.dvdstore.DvdModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DvdStoreRepositoryInterface extends CrudRepository<DvdModel, Long> {
    
    List<DvdModel> findByName ( String name);
    DvdModel findById ( long id);

}
