package com.simplon.dvdstorecart.services.panier;

import com.simplon.dvdstorecart.controllers.panier.PanierGetDTO;
import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.panier.PanierRepository;
import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import com.simplon.dvdstorecart.services.panierdvd.PanierDvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanierService {

    @Autowired
    PanierRepository panierRepository;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;



//GET ALL
    public List<PanierServiceModel> findAll() {
        List<PanierRepositoryModel> panier =  panierRepository.findAll(); // on Récupère nos infos du repository
        List<PanierServiceModel> panierServiceModel = dvdStoreCartMapper.arrayListPanierRepositoryToService(panier); // On envoi au mapper qui retourne une ArrayList<PanierServiceModel>

        // Plus rapide :
        // List<PanierServiceModel> panierServiceModel = dvdStoreCartMapper.arrayListRepositoryToService(panierRepository.findAll());

        return panierServiceModel;
    }


//GET ONE

    public PanierServiceModel findById(@PathVariable Long id){
        PanierRepositoryModel panierRepositoryModel = panierRepository.findById(id).orElse(null);
        return dvdStoreCartMapper.repositoryPanierToService(panierRepositoryModel);
    }
}
