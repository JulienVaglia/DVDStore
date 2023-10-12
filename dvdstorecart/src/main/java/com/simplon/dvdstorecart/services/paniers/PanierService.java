package com.simplon.dvdstorecart.services.paniers;

import com.simplon.dvdstorecart.repositories.paniers.PanierRepository;
import com.simplon.dvdstorecart.repositories.paniers.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;

public class PanierService {

    @Autowired
    PanierRepository panierRepository;

    //CREATE
    public boolean add(PanierServiceModel panierServiceModel) {

        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(

                panierServiceModel.getMontant(),
                panierServiceModel.getDate_validation(),
                panierServiceModel.getClient_id(),
                panierServiceModel.getQuantity(),
                panierServiceModel.getPrice())
        ;
                PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);

                return panierRepositoryModelReturned != null;






    }
}
