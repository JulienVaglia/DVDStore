package com.simplon.dvdstore.controllers.clients;

import com.simplon.dvdstore.services.clients.ClientService;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
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

}
