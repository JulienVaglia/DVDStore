package com.simplon.dvdstore.services.clients;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


//CREATE
    public boolean add(ClientServiceModel clientServiceModel) {

        ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(
                clientServiceModel.getNom(),
                clientServiceModel.getPrenom(),
                clientServiceModel.getAddresse());

        ClientRepositoryModel clientRepositoryModelReturned = clientRepository.save(clientRepositoryModel);

        return clientRepositoryModelReturned != null;
    }


//GET ALL
public ArrayList<ClientServiceModel> findAll()
    {

        ArrayList<ClientServiceModel> clientServiceModelArrayList = new ArrayList<>();
        ArrayList<ClientRepositoryModel> clientRepositoryModelArrayList = clientRepository.findAll();
            for (ClientRepositoryModel x: clientRepositoryModelArrayList){
                clientServiceModelArrayList.add(new ClientServiceModel(
                Optional.ofNullable(x.getId()),
                x.getNom(),
                x.getPrenom(),
                x.getAddresse()));
            }
            return clientServiceModelArrayList;
        }


// GET ONE
    public ClientServiceModel findById(Long id) {

        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(id);

        if ( clientRepositoryModel.isEmpty())
            {
               return null;
            }
        else
            {
                return new ClientServiceModel(
                        Optional.ofNullable(clientRepositoryModel.get().getId()),
                        clientRepositoryModel.get().getNom(),
                        clientRepositoryModel.get().getPrenom(),
                        clientRepositoryModel.get().getAddresse());
            }
    }


//UPDATE
    public boolean update(ClientServiceModel clientServiceModel) {

        if (clientRepository != null){

            ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(
                    clientServiceModel.getId().get(),
                    clientServiceModel.getNom(),
                    clientServiceModel.getPrenom(),
                    clientServiceModel.getAddresse()
            );

            ClientRepositoryModel updateclientRepositoryModel =  clientRepository.save(clientRepositoryModel);
            return updateclientRepositoryModel != null;
        }
        else
            {
                return false;
            }



    }



//DELETE ALL
//DELETE ONE








    }










