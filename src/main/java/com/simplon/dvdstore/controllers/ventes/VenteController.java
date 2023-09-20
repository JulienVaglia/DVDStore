package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
                    venteDTO.quantity(),
                    venteDTO.id_dvd(),
                    venteDTO.id_client());

            venteService.add(venteServiceModel);

            return venteService.add(venteServiceModel);

        }

//GET ALL
    @GetMapping
    public ArrayList<VenteGetDTO> findAll()
        {
            ArrayList<VenteGetDTO> venteGetDTOArrayList = new ArrayList<>();
            ArrayList<VenteServiceModel> venteServiceModelArrayList = venteService.findAll();

            for (VenteServiceModel x : venteServiceModelArrayList) {
                venteGetDTOArrayList.add( new VenteGetDTO(
                        x.getId().get(),
                        x.getDate(),
                        x.getMontant(),
                        x.getQuantity(),
                        x.getId_client(),
                        x.getId_dvd()));

            }

            return venteGetDTOArrayList;

        }





}
