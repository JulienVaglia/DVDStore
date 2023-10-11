package com.simplon.dvdstore.services.clients;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Client service.
 */
@Service
public class ClientService {

    /**
     * The Client repository.
     */
    @Autowired
    ClientRepository clientRepository;


    /**
     * Add boolean.
     *
     * @param clientServiceModel the client service model
     * @return the boolean
     */
//CREATE
    public boolean add(ClientServiceModel clientServiceModel) {

        ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(
                clientServiceModel.getNom(),
                clientServiceModel.getPrenom(),
                clientServiceModel.getAdresse());

        ClientRepositoryModel clientRepositoryModelReturned = clientRepository.save(clientRepositoryModel);

        return clientRepositoryModelReturned != null;
    }


    /**
     * Find all array list.
     *
     * @return the array list
     */
//GET ALL
public ArrayList<ClientServiceModel> findAll()
    {

        ArrayList<ClientRepositoryModel> clientRepositoryModelArrayList = clientRepository.findAll();
        ArrayList<ClientServiceModel> clientServiceModelArrayList = new ArrayList<>();

            for ( ClientRepositoryModel x: clientRepositoryModelArrayList ){
                clientServiceModelArrayList.add(new ClientServiceModel(
                Optional.ofNullable(x.getId()),
                x.getNom(),
                x.getPrenom(),
                x.getAdresse()));
            }
            return clientServiceModelArrayList;
        }


    /**
     * Find by id client service model.
     *
     * @param id the id
     * @return the client service model
     */
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
                        clientRepositoryModel.get().getAdresse());
            }
    }


    /**
     * Update boolean.
     *
     * @param clientServiceModel the client service model
     * @return the boolean
     */
//UPDATE
    public boolean update(ClientServiceModel clientServiceModel) {

        if (clientRepository != null){

            ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(
                    clientServiceModel.getId().get(),
                    clientServiceModel.getNom(),
                    clientServiceModel.getPrenom(),
                    clientServiceModel.getAdresse()
            );

            ClientRepositoryModel updateClientRepositoryModel =  clientRepository.save(clientRepositoryModel);
            return updateClientRepositoryModel != null;
        }
        else
            {
                return false;
            }



    }


    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
//DELETE ONE
    public boolean delete(Long id) {
        if (clientRepository.existsById(id))
            {
                clientRepository.deleteById(id);
                return true;
            }
        else
            {
                return false;
            }

    }


    /**
     * Delete all boolean.
     *
     * @return the boolean
     */
//DELETE ALL
    public boolean deleteAll() {
        if (clientRepository != null)
            {
                clientRepository.deleteAll();
                return true;
            }
        else
            {
                return false;
            }
    }









    }










