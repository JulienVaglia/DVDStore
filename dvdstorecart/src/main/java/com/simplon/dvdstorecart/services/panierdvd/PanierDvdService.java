package com.simplon.dvdstorecart.services.panierdvd;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepository;
import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanierDvdService {


    @Autowired
    PanierDvdRepository panierRepository;
    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;
    @Autowired
    EntityManager entityManager;

// CREATE




    public boolean add(PanierDvdServiceModel panierServiceModel) {

        PanierDvdRepositoryModel panierRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierServiceModel);

        PanierDvdRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);

        // methode n°1
//        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("prix_total_dvd");
//        // Définir les paramètres de la procédure stockée
//        storedProcedure.registerStoredProcedureParameter("dvd_id", Long.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("panier_id", Long.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("dvd_prix", Float.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("quantite", Integer.class, ParameterMode.IN);
//
//        storedProcedure.setParameter("dvd_id", panierServiceModel.getDvd_id());
//        storedProcedure.setParameter("panier_id", panierServiceModel.getPanier_id());
//        storedProcedure.setParameter("dvd_prix",  panierServiceModel.getDvd_prix());
//        storedProcedure.setParameter("quantite", panierServiceModel.getQuantite());
//
//        storedProcedure.execute();

// methode n°2
        panierRepository.prix_total_dvd( panierServiceModel.getDvd_id(),
                panierServiceModel.getPanier_id(),
                panierServiceModel.getDvd_prix(),
                panierServiceModel.getQuantite());

        /// // methode n°3
//        panierRepository.prixTotalDvd(
//                panierServiceModel.getDvd_id(),
//                panierServiceModel.getPanier_id(),
//                panierServiceModel.getDvd_prix(),
//                panierServiceModel.getQuantite()
//                );



        return panierRepositoryModelReturned != null;
    }


// GET All

    public List<PanierDvdServiceModel> findAll() {
        List<PanierDvdRepositoryModel> paniers = panierRepository.findAll(); // on Récupère nos infos du repository
        List<PanierDvdServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(paniers); // On envoi au mapper qui retourne une ArrayList<PanierServiceModel>

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
