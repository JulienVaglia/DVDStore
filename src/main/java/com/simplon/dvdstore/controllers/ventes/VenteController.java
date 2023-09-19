package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
                    venteDTO.dvdStoreGetDTO(),
                    venteDTO.clientGetDTO(),
                    venteDTO.quantity());

//                    venteDTO.nom(),
//                    venteDTO.prenom(),
//                    venteDTO.product()


            venteService.add(venteServiceModel);

            return venteService.add(venteServiceModel);

        }







}
