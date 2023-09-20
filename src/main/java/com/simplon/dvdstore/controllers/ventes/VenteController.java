package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ventes")
@NoArgsConstructor
public class VenteController {


    @Autowired
    VenteService venteService;



// Create
    @PostMapping
    public boolean add (@RequestBody VenteDTO venteDTO)
        {
            VenteServiceModel venteServiceModel = new VenteServiceModel(
                    venteDTO.montant(),
                    venteDTO.id_dvd(),
                    venteDTO.id_client(),
                    venteDTO.quantity());

            venteService.add(venteServiceModel);

            return venteService.add(venteServiceModel);

        }







}
