package com.simplon.dvdstorecart.controllers.paniers;
import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.services.paniers.PanierService;
import com.simplon.dvdstorecart.services.paniers.PanierServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/panier")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PanierController {


    @Autowired
    PanierService panierService;
    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;


// Create
    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public boolean add (@RequestBody PanierGetDTO panierGetDTO)
    {
        PanierServiceModel panierServiceModel = dvdStoreCartMapper.dtoToService(panierGetDTO);

        // dvdMapper.dtoToService(panierGetDTO); vaut :

//        PanierServiceModel panierServiceModel = new PanierServiceModel(
//                panierGetDTO.montant(),
//                panierGetDTO.date_validation(),
//                panierGetDTO.client_id(),
//                panierGetDTO.quantity(),
//                panierGetDTO.price()
//        );

        return panierService.add(panierServiceModel);
    }



// GET all
    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public ArrayList<PanierGetDTO> findAll(){

//        Etapes par etapes :
//        ArrayList<PanierServiceModel> paniers = panierService.findAll();
//        ArrayList<PanierGetDTO> panierGetDTOS = dvdStoreCartMapper.arrayListServiceToDTO(paniers);
//        return panierGetDTOS;

        return dvdStoreCartMapper.arrayListServiceToDTO(panierService.findAll());
    }



//    Get One
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public PanierGetDTO findByID(Long id){

//        PanierServiceModel panier = panierService.findByID(id);
//        PanierGetDTO panierGetDTO = dvdStoreCartMapper.serviceToDTO(panier);
//        return panierGetDTO;

        return dvdStoreCartMapper.serviceToDTO(panierService.findByID(id));
    }


//UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public boolean update (Long id, @RequestBody PanierGetDTO panierGetDTO){

        PanierServiceModel panierServiceModel = dvdStoreCartMapper.dtoToService(panierGetDTO);
        return panierService.update(panierServiceModel);

    }
}
