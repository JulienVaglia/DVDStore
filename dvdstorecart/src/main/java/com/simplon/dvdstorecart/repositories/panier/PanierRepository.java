package com.simplon.dvdstorecart.repositories.panier;

import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanierRepository extends CrudRepository<PanierRepositoryModel, Long> {

    List<PanierRepositoryModel>findAll();


}
