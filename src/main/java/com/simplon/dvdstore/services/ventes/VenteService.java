package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    DvdStoreRepository dvdStoreRepository;
    @Autowired
    ClientRepository clientRepository;





// Create
    public boolean add(VenteServiceModel venteServiceModel) {


        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(

                venteServiceModel.getMontant(),
                dvdStoreRepository.findById(venteServiceModel.getId_dvd()).get(),
                clientRepository.findById(venteServiceModel.getId_client()).get(),
                venteServiceModel.getQuantity());

        VenteRepositoryModel venteRepositoryModelReturned = venteRepository.save(venteRepositoryModel);

        return venteRepositoryModelReturned != null;

    }

}
