package com.simplon.dvdstore.controllers.clients;

import com.simplon.dvdstore.services.clients.ClientService;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

//CREATE
    @PostMapping
    public boolean add( @RequestBody ClientDTO clientDTO )
    {
        ClientServiceModel clientServiceModel = new ClientServiceModel(
                clientDTO.nom(),
                clientDTO.prenom(),
                clientDTO.addresse());

                return clientService.add(clientServiceModel);
    }


//GET ALL
    @GetMapping
    public ArrayList<ClientGetDTO> findAll()
        {

            ArrayList<ClientGetDTO> clientGetDTOArrayList = new ArrayList<>();
            ArrayList<ClientServiceModel> clientServiceModelArrayList = clientService.findAll();
            for (ClientServiceModel x: clientServiceModelArrayList){
                clientGetDTOArrayList.add(new ClientGetDTO(
                x.getId().get(),
                x.getNom(),
                x.getPrenom(),
                x.getAddresse()));
            }

            return clientGetDTOArrayList;

        }


//GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<ClientGetDTO> findById(@PathVariable Long id){

        ClientServiceModel clientServiceModel = clientService.findById(id);

        if (clientServiceModel != null)
            {
                ClientGetDTO clientGetDTO = new ClientGetDTO(
                        clientServiceModel.getId().get(),
                        clientServiceModel.getNom(),
                        clientServiceModel.getPrenom(),
                        clientServiceModel.getAddresse()
                );
                return new ResponseEntity<>(clientGetDTO, HttpStatus.OK);
            }
        else
            {
                return ResponseEntity.badRequest().body(null);
            }
    }


//UPDATE
    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") Optional<Long> id, @RequestBody ClientDTO clientDTO){

        ClientServiceModel clientServiceModel = new ClientServiceModel(
                id,
                clientDTO.nom(),
                clientDTO.prenom(),
                clientDTO.addresse());

        return clientService.update(clientServiceModel);
    }


//DELETE ONE
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id)
    {
        return clientService.delete(id);
    }


//DELETE ALL
    @DeleteMapping("/")
    public boolean deleteAll()
    {
        return clientService.deleteAll();
    }






}
