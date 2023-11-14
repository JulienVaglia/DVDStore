package com.simplon.dvdstore.controllers.clients;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.services.clients.ClientService;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Client controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/clients")
public class ClientController {

    /**
     * The Client service.
     */
    @Autowired
    ClientService clientService;
    /**
     * The Client repository.
     */
    @Autowired
    ClientRepository clientRepository;

    /**
     * Add boolean.
     *
     * @param clientDTO the client dto
     * @return the boolean
     */
//CREATE
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public boolean add( @RequestBody ClientDTO clientDTO )
    {
        ClientServiceModel clientServiceModel = new ClientServiceModel(
                clientDTO.nom(),
                clientDTO.prenom(),
                clientDTO.adresse());

                return clientService.add(clientServiceModel);
    }


//GET ALL

    /**
     * Find all array list.
     *
     * @return the array list
     */
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
                x.getAdresse()));
            }

            return clientGetDTOArrayList;

        }


    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
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
                        clientServiceModel.getAdresse()
                );
                return new ResponseEntity<>(clientGetDTO, HttpStatus.OK);
            }
        else
            {
                return ResponseEntity.badRequest().body(null);
            }
    }


    /**
     * Update boolean.
     *
     * @param id        the id
     * @param clientDTO the client dto
     * @return the boolean
     */
//UPDATE
@PreAuthorize("hasAuthority('admin')")
    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") Optional<Long> id, @RequestBody ClientDTO clientDTO){

        ClientServiceModel clientServiceModel = new ClientServiceModel(
                id,
                clientDTO.nom(),
                clientDTO.prenom(),
                clientDTO.adresse());

        return clientService.update(clientServiceModel);
    }


    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
//DELETE ONE
@PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id)
    {
        return clientService.delete(id);
    }


    /**
     * Delete all boolean.
     *
     * @return the boolean
     */
//DELETE ALL
@PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/")
    public boolean deleteAll()
    {
        return clientService.deleteAll();
    }






}
