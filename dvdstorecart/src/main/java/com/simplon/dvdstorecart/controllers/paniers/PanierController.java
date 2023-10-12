package com.simplon.dvdstorecart.controllers.paniers;

import com.simplon.dvdstorecart.controllers.paniers.panier.PanierDTO;
import com.simplon.dvdstorecart.services.paniers.PanierService;
import com.simplon.dvdstorecart.services.paniers.PanierServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/panier")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
//@PreAuthorize("hasAuthority('admin')")
public class PanierController {

    @Autowired
    PanierService panierService;



    // Create
    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public boolean add (@RequestBody PanierDTO panierDTO)
    {

        PanierServiceModel panierServiceModel = new PanierServiceModel(
                panierDTO.montant(),
                panierDTO.date_validation(),
                panierDTO.client_id(),
                panierDTO.quantity(),
                panierDTO.price()
        );



        return panierService.add(panierServiceModel);

    }




}
