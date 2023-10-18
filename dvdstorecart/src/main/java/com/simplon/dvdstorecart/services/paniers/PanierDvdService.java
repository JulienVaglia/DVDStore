package com.simplon.dvdstorecart.services.paniers;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.paniers.PanierRepository;
import com.simplon.dvdstorecart.repositories.paniers.PanierDvdRepository;
import com.simplon.dvdstorecart.repositories.paniers.PanierDvdRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PanierDvdService {


    @Autowired
    PanierDvdRepository panierRepository;

    @Autowired
    PanierRepository finalPanierRepository;

// CREATE

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;


    public boolean add(PanierDvdServiceModel panierServiceModel) {

        PanierDvdRepositoryModel panierRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierServiceModel);

//        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(
//
//                panierServiceModel.getMontant(),
//                panierServiceModel.getDate_validation(),
//                panierServiceModel.getClient_id(),
//                panierServiceModel.getQuantity(),
//                panierServiceModel.getPrice())
//        ;
        PanierDvdRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);

        return panierRepositoryModelReturned != null;
    }


// GET All

    public ArrayList<PanierDvdServiceModel> findAll() {
        Iterable<PanierDvdRepositoryModel> paniers = panierRepository.findAll(); // on Récupère nos infos du repository
        ArrayList<PanierDvdServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(paniers); // On envoi au mapper qui retourne une ArrayList<PanierServiceModel>

        // Plus rapide :
        // ArrayList<PanierServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(panierRepository.findAll());

        return panierServiceModels;
    }


// GET One

    public PanierDvdServiceModel findByID(Long id)
        {
            PanierDvdRepositoryModel panier = null;

            if ( panierRepository.findById(id).isPresent()) {
                panier = panierRepository.findById(id).get();
            }

            return dvdStoreCartMapper.repositoryToService(panier);


        }


// UPDATE
    public boolean update(PanierDvdServiceModel panierServiceModel) {

//        PanierRepositoryModel panierRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierServiceModel);
//        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);
//        return panierRepositoryModelReturned != null;

        panierRepository.save(dvdStoreCartMapper.serviceToRepository(panierServiceModel));
        return true;

    }


// DELETE
    public boolean delete(Long id) {
        if (panierRepository.existsById(id))
        {
            panierRepository.deleteById(id);
            return true;
        }
        return false;
    }


// DELETE ALL
    public boolean deleteAll(){
        if (panierRepository != null)
        {
            panierRepository.deleteAll();
            return true;
        }
        return false;

    }

}
