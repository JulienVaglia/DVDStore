package com.simplon.dvdstorecart.controllers.panier;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.repositories.panier.PanierRepository;
import com.simplon.dvdstorecart.services.panier.PanierService;
import com.simplon.dvdstorecart.services.panier.PanierServiceModel;
import com.simplon.dvdstorecart.services.panierdvd.PanierDvdService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/panier")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PanierController {

    @Autowired
    PanierService panierService;
    @Autowired
    PanierDvdService panierDvdService;

    @Autowired
    PanierRepository panierRepository;


    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;


//GET ALL
    @GetMapping
    public List<PanierGetDTO> findAll(){

//        List<PanierServiceModel>panierServiceModels = panierService.findAll();
//        List <PanierGetDTO> panierGetDTOS = dvdStoreCartMapper.arrayListPanierServiceToDTO(panierServiceModels);
//
//        return panierGetDTOS;

        return dvdStoreCartMapper.arrayListPanierServiceToDTO(panierService.findAll());
    }

//GET One

    @GetMapping("/{id}")
    public PanierGetDTO findById(@PathVariable Long id){
        PanierServiceModel panierServiceModel = panierService.findById(id);
        return dvdStoreCartMapper.panierServiceToPanierDTO(panierServiceModel);
    }



}
