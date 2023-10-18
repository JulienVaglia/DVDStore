package com.simplon.dvdstorecart.controllers.paniers.panier;
import com.simplon.dvdstorecart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstorecart.services.paniers.PanierDvdService;
import com.simplon.dvdstorecart.services.paniers.PanierDvdServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/paniers")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PanierDvdController {


    @Autowired
    PanierDvdService panierService;
    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;


// Create
    @PostMapping
    public boolean add (@RequestBody PanierDvdGetDTO panierGetDTO)
    {
        PanierDvdServiceModel panierServiceModel = dvdStoreCartMapper.dtoToService(panierGetDTO);

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



// GET ALL
    @GetMapping

    public ArrayList<PanierDvdGetDTO> findAll(){

//        Etapes par etapes :
//        ArrayList<PanierServiceModel> paniers = panierService.findAll();
//        ArrayList<PanierGetDTO> panierGetDTOS = dvdStoreCartMapper.arrayListServiceToDTO(paniers);
//        return panierGetDTOS;

        return dvdStoreCartMapper.arrayListServiceToDTO(panierService.findAll());
    }


// Get One
    @GetMapping("/{id}")

    public PanierDvdGetDTO findByID(@PathVariable Long id){

//        PanierServiceModel panier = panierService.findByID(id);
//        PanierGetDTO panierGetDTO = dvdStoreCartMapper.serviceToDTO(panier);
//        return panierGetDTO;

        return dvdStoreCartMapper.serviceToDTO(panierService.findByID(id));
    }


// UPDATE
    @PutMapping("/{id}")

    public boolean update (@PathVariable("id") Long id, @RequestBody PanierDvdGetDTO panierGetDTO){

        PanierDvdServiceModel panierServiceModel = dvdStoreCartMapper.dtoToService(panierGetDTO);
        return panierService.update(panierServiceModel);

    }

// DELETE
     @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return panierService.delete(id);
     }


// DELETE ALL
    @DeleteMapping
    public boolean deleteAll(){
        return panierService.deleteAll();
    }

}
