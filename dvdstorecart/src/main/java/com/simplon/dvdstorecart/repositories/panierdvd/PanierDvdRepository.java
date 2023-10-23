package com.simplon.dvdstorecart.repositories.panierdvd;

import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanierDvdRepository extends CrudRepository<PanierDvdRepositoryModel, Long> {

    List<PanierDvdRepositoryModel> findAll();

    @Procedure(name= "prix_total_dvd")
    void prix_total_dvd(Long dvd_id, Long panier_id, Float dvd_prix, int quantite);

}
