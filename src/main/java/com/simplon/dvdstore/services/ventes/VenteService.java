package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.repositories.ventes.VenteRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;

// Create
    public boolean add(VenteServiceModel venteServiceModel) {


        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(

                venteServiceModel.getMontant(),
                venteServiceModel.getDvdStoreGetDTO(),
                venteServiceModel.getDvdStoreGetDTO(),
                venteServiceModel.getQuantity());

        VenteRepositoryModel venteRepositoryModelReturned = venteRepository.save(venteRepositoryModel);

        return venteRepositoryModelReturned != null;




    }


}
