package com.simplon.dvdstorecart.controllers.panier;

import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.services.panier.PanierService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/panier")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PanierController {

    @Autowired
    PanierService panierService;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;


//GET ALL
    @GetMapping
    public List<PanierGetDTO> findAll(){

        return dvdStoreCartMapper.arrayListPanierServiceToDTO(panierService.findAll());
    }

}
