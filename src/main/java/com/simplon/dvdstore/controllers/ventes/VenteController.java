package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDTO;
import com.simplon.dvdstore.services.clients.ClientService;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

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
                       x.getDvd().getId().get(),
                       x.getDvd().getName(),
                       x.getDvd().getGenre(),
                       x.getDvd().getQuantity(),
                       x.getDvd().getPrice(),
                       x.getDvd().getPhoto(),
                       x.getDvd().getDescription());

                ClientGetDTO clientGetDTO = new ClientGetDTO(
                        x.getClient().getId().get(),
                        x.getClient().getNom(),
                        x.getClient().getPrenom(),
                        x.getClient().getAddresse());

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
                    venteServiceModel.getDvd().getId().get(),
                    venteServiceModel.getDvd().getName(),
                    venteServiceModel.getDvd().getGenre(),
                    venteServiceModel.getDvd().getQuantity(),
                    venteServiceModel.getDvd().getPrice(),
                    venteServiceModel.getDvd().getPhoto(),
                    venteServiceModel.getDvd().getDescription()
            );

            ClientGetDTO clientGetDTO = new ClientGetDTO(
                    venteServiceModel.getClient().getId().get(),
                    venteServiceModel.getClient().getNom(),
                    venteServiceModel.getClient().getPrenom(),
                    venteServiceModel.getClient().getAddresse());


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


// UPDATE
@PutMapping("/{id}")
public boolean update(@PathVariable("id") Optional<Long> id, @PathVariable("date") Date date, @RequestBody VenteDTO venteDTO){



    VenteServiceModel venteServiceModel = new VenteServiceModel(
            id,
            date,
            venteDTO.montant(),
            venteDTO.quantity(),
            venteDTO.id_dvd(),
            venteDTO.id_client());

   return venteService.update(venteServiceModel);

}


//DELETE ONE
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id)
        {
            return venteService.delete(id);
        }


//DELETE ALL
    @DeleteMapping("/")
    public boolean deleteAll()
        {
            return venteService.deleteAll();
        }



}
