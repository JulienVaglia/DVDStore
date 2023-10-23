package com.simplon.dvdstorecart.services.panier;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.panier.PanierRepository;
import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanierService {

    @Autowired
    PanierRepository panierRepository;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    public List<PanierServiceModel> findAll() {
        List<PanierRepositoryModel> panier =  panierRepository.findAll(); // on Récupère nos infos du repository
        List<PanierServiceModel> panierServiceModel = dvdStoreCartMapper.arrayListPanierRepositoryToService(panier); // On envoi au mapper qui retourne une ArrayList<PanierServiceModel>

        // Plus rapide :
        // ArrayList<PanierServiceModel> panierServiceModel = dvdStoreCartMapper.arrayListRepositoryToService(panierRepository.findAll());

        return panierServiceModel;
    }
}
