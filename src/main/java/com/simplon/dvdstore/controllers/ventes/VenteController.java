package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;
import com.simplon.dvdstore.services.clients.ClientService;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("ventes")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VenteController {


    @Autowired
    VenteService venteService;
    @Autowired
    DvdStoreService dvdService;
    @Autowired
    ClientService clientService;



// Create
    @PostMapping
    public boolean add (@RequestBody VenteDTO venteDTO)
        {

            VenteServiceModel venteServiceModel = new VenteServiceModel(
                    venteDTO.montant(),
                    venteDTO.quantity(),
                    dvdService.findById(venteDTO.id_dvd()),
                    clientService.findById(venteDTO.id_client()));

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

               DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(
                       x.getId_dvd().getId().get(),
                       x.getId_dvd().getName(),
                       x.getId_dvd().getGenre(),
                       x.getId_dvd().getQuantity(),
                       x.getId_dvd().getPrice(),
                       x.getId_dvd().getPhoto(),
                       x.getId_dvd().getDescription());

                ClientGetDTO clientGetDTO = new ClientGetDTO(
                        x.getId_client().getId().get(),
                        x.getId_client().getNom(),
                        x.getId_client().getPrenom(),
                        x.getId_client().getAddresse());

                venteGetDTOArrayList.add( new VenteGetDTO(
                        x.getId().get(),
                        x.getDate(),
                        x.getMontant(),
                        x.getQuantity(),
                        dvdStoreGetDTO,
                        clientGetDTO));

            }

            return venteGetDTOArrayList;

        }


// GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<VenteGetDTO> findbyid(@PathVariable Long id) {
        VenteServiceModel venteServiceModel = venteService.findById(id);

        if (venteServiceModel != null) {
            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(
                    venteServiceModel.getId_dvd().getId().get(),
                    venteServiceModel.getId_dvd().getName(),
                    venteServiceModel.getId_dvd().getGenre(),
                    venteServiceModel.getId_dvd().getQuantity(),
                    venteServiceModel.getId_dvd().getPrice(),
                    venteServiceModel.getId_dvd().getPhoto(),
                    venteServiceModel.getId_dvd().getDescription()
            );

            ClientGetDTO clientGetDTO = new ClientGetDTO(
                    venteServiceModel.getId_client().getId().get(),
                    venteServiceModel.getId_client().getNom(),
                    venteServiceModel.getId_client().getPrenom(),
                    venteServiceModel.getId_client().getAddresse());


            VenteGetDTO venteGetDTO = new VenteGetDTO(
                    venteServiceModel.getId().get(),
                    venteServiceModel.getDate(),
                    venteServiceModel.getMontant(),
                    venteServiceModel.getQuantity(),
                    dvdStoreGetDTO,
                    clientGetDTO
            );

            return new ResponseEntity<>(venteGetDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }





}
