package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/cart")
@AllArgsConstructor
public class FeignClientController {

    private final MicroservicePanierProxy panierProxy;

    @Autowired
    ClientRepository clientRepository;


    @GetMapping("/{id}")
    PanierFrontDto findById (@PathVariable("id") Long id)
    {
        PanierDto panierDto = panierProxy.findById(id);

        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(panierDto.client_id()).orElse(null);
        ClientGetDTO clientGetDTO = new ClientGetDTO(
                clientRepositoryModel.getId(),
                clientRepositoryModel.getNom(),
                clientRepositoryModel.getPrenom(),
                clientRepositoryModel.getAdresse()
        );


        // mapper
        PanierFrontDto panierFrontDto = new PanierFrontDto(
                panierDto.id(),
                panierDto.montant(),
                panierDto.date_validation(),
                clientGetDTO,
                panierDto.dvds());
        return panierFrontDto;

    }

    @GetMapping
    public ArrayList<PanierDvdGetDTO> findAll(){
        return panierProxy.findAll();
    }

    @PostMapping
    public boolean addDvdPrice ( @RequestBody PanierDvdGetDTO panierDvdGetDTO ){
        return panierProxy.addDvdPrice(panierDvdGetDTO);
    }
}
