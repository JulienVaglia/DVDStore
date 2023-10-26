package com.simplon.dvdstorecart.services.panierdvd;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.panier.PanierRepository;
import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepository;
import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierDvdService {


    @Autowired
    PanierDvdRepository panierDvdRepository;
    @Autowired
    PanierRepository panierRepository;
    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;
    @Autowired
    EntityManager entityManager;

// CREATE




    public boolean add(PanierDvdServiceModel panierServiceModel) {

        PanierDvdRepositoryModel panierRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierServiceModel);

        PanierDvdRepositoryModel panierRepositoryModelReturned = panierDvdRepository.save(panierRepositoryModel);

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
        panierDvdRepository.prix_total_dvd( panierServiceModel.getDvd_id(),
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
        List<PanierDvdRepositoryModel> paniers = panierDvdRepository.findAll(); // on Récupère nos infos du repository
        List<PanierDvdServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(paniers); // On envoi au mapper qui retourne une ArrayList<PanierServiceModel>

        // Plus rapide :
        // ArrayList<PanierServiceModel> panierServiceModels = dvdStoreCartMapper.arrayListRepositoryToService(panierRepository.findAll());

        return panierServiceModels;
    }

    public List<PanierDvdRepositoryModel> findAllByPanierRepositoryModel(Long id) {

        PanierRepositoryModel panier = panierRepository.findById(id).get();

        return panierDvdRepository.findAllByPanierRepositoryModel(panier);
    }
// GET One

    public PanierDvdServiceModel findByID(Long id)
        {
            PanierDvdRepositoryModel panier = null;

            if ( panierDvdRepository.findById(id).isPresent()) {
                panier = panierDvdRepository.findById(id).get();
            }

            return dvdStoreCartMapper.repositoryToService(panier);


        }


// UPDATE
    public boolean update(PanierDvdServiceModel panierServiceModel) {

        panierDvdRepository.save(dvdStoreCartMapper.serviceToRepository(panierServiceModel));
        return true;

    }


// DELETE
    public boolean delete(Long id) {
        if (panierDvdRepository.existsById(id))
        {
            panierDvdRepository.deleteById(id);
            return true;
        }
        return false;
    }


// DELETE ALL
    public boolean deleteAll(){
        if (panierDvdRepository != null)
        {
            panierDvdRepository.deleteAll();
            return true;
        }
        return false;

    }

}
