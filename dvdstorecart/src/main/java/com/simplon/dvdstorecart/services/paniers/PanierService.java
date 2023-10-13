package com.simplon.dvdstorecart.services.paniers;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.paniers.PanierRepository;
import com.simplon.dvdstorecart.repositories.paniers.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PanierService {

    @Autowired
    PanierRepository panierRepository;

// CREATE

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;


    public boolean add(PanierServiceModel panierServiceModel) {

        PanierRepositoryModel panierRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierServiceModel);

//        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(
//
//                panierServiceModel.getMontant(),
//                panierServiceModel.getDate_validation(),
//                panierServiceModel.getClient_id(),
//                panierServiceModel.getQuantity(),
//                panierServiceModel.getPrice())
//        ;
        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);

        return panierRepositoryModelReturned != null;
    }


// GET All

    public ArrayList<PanierServiceModel> findAll() {
        Iterable<PanierRepositoryModel> paniers = panierRepository.findAll(); // on Récupère nos infos du repository
        ArrayList<PanierServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(paniers); // On envoi au mapper qui retourne une ArrayList<PanierServiceModel>

        // Plus rapide :
        // ArrayList<PanierServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(panierRepository.findAll());

        return panierServiceModels;
    }


// GET One

    public PanierServiceModel findByID(Long id)
        {
            PanierRepositoryModel panier = null;

            if ( panierRepository.findById(id).isPresent()) {
                panier = panierRepository.findById(id).get();
            }

            return dvdStoreCartMapper.repositoryToService(panier);


        }


// UPDATE
    public boolean update(PanierServiceModel panierServiceModel) {

//        PanierRepositoryModel panierRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierServiceModel);
//        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);
//        return panierRepositoryModelReturned != null;

        panierRepository.save(dvdStoreCartMapper.serviceToRepository(panierServiceModel));
        return true;


    }
}
