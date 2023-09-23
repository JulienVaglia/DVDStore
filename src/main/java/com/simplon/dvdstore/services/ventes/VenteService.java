package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.controllers.ventes.VenteDTO;
import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    DvdStoreRepository dvdStoreRepository;
    @Autowired
    ClientRepository clientRepository;


// Create
    public boolean add(VenteServiceModel venteServiceModel) {

        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(venteServiceModel.getId_dvd().getId().get());
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(venteServiceModel.getId_client().getId().get());

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(

                venteServiceModel.getMontant(),
                dvdRepositoryModel.get(),
                clientRepositoryModel.get(),
                venteServiceModel.getQuantity());

        VenteRepositoryModel venteRepositoryModelReturned = venteRepository.save(venteRepositoryModel);

        return venteRepositoryModelReturned != null;

    }


// GET ALL
    public ArrayList<VenteServiceModel> findAll() {



        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();
        ArrayList<VenteServiceModel> venteServiceModelArrayList = new ArrayList<>();

        for ( VenteRepositoryModel x: venteRepositoryModels ){

            DvdServiceModel dvdServiceModel = new DvdServiceModel(
                    Optional.ofNullable(x.getDvdRepositoryModel().getId()),
                    x.getDvdRepositoryModel().getName(),
                    x.getDvdRepositoryModel().getGenre(),
                    x.getDvdRepositoryModel().getQuantity(),
                    x.getDvdRepositoryModel().getPrice(),
                    x.getDvdRepositoryModel().getPhoto(),
                    x.getDvdRepositoryModel().getDescription());

            ClientServiceModel clientServiceModel = new ClientServiceModel(
                    Optional.ofNullable(x.getId()),
                    x.getClientRepositoryModel().getNom(),
                    x.getClientRepositoryModel().getPrenom(),
                    x.getClientRepositoryModel().getAddresse());

            venteServiceModelArrayList.add((new VenteServiceModel(
                    Optional.ofNullable(x.getId()),
                    x.getDate(),
                    x.getMontant(),
                    x.getQuantity(),
                    dvdServiceModel,
                    clientServiceModel)));

        }
        return venteServiceModelArrayList;
    }


// GET ONE
    public VenteServiceModel findById(Long id) {

        Optional<VenteRepositoryModel> venteRepositoryModel = venteRepository.findById(id);


        if ( venteRepositoryModel.isEmpty())
        {
            return null;
        }
        else
        {

            //Récupération des données de DVD dans "dvdServiceModel"
            DvdServiceModel dvdServiceModel = new DvdServiceModel(
                    Optional.ofNullable(venteRepositoryModel.get().getDvdRepositoryModel().getId()),
                    venteRepositoryModel.get().getDvdRepositoryModel().getName(),
                    venteRepositoryModel.get().getDvdRepositoryModel().getGenre(),
                    venteRepositoryModel.get().getDvdRepositoryModel().getQuantity(),
                    venteRepositoryModel.get().getDvdRepositoryModel().getPrice(),
                    venteRepositoryModel.get().getDvdRepositoryModel().getPhoto(),
                    venteRepositoryModel.get().getDvdRepositoryModel().getDescription()
            );

            //Récupération des données de Client dans "clientServiceModel"
            ClientServiceModel clientServiceModel = new ClientServiceModel(
                    Optional.ofNullable(venteRepositoryModel.get().getClientRepositoryModel().getId()),
                    venteRepositoryModel.get().getClientRepositoryModel().getNom(),
                    venteRepositoryModel.get().getClientRepositoryModel().getPrenom(),
                    venteRepositoryModel.get().getClientRepositoryModel().getAddresse()
            );

            //Chargement des données dans la couche Vente
            return new VenteServiceModel(
                    Optional.ofNullable(venteRepositoryModel.get().getId()),
                    venteRepositoryModel.get().getDate(),
                    venteRepositoryModel.get().getMontant(),
                    venteRepositoryModel.get().getQuantity(),
                    dvdServiceModel,
                    clientServiceModel);

        }
    }




//UPDATE
//public boolean update(VenteServiceModel venteServiceModel) {
//
//        if (venteRepository != null)
//            {
//
//                VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(
//                        venteServiceModel.getId().get(),
//                        venteServiceModel.getDate(),
//                        venteServiceModel.getMontant(),
//                        dvdStoreRepository.findById(venteServiceModel),
//                        clientRepository.findById(venteServiceModel),
//                        venteServiceModel.getQuantity());
//
//                //On enregistre les nouvelles données de venteRepositoryModel dans venteRepository
//                VenteRepositoryModel updateVenteRepositoryModel = venteRepository.save(venteRepositoryModel);
//
//                return updateVenteRepositoryModel != null;
//
//        }
//        else
//        {
//            return false;
//        }
//
//}


//DELETE
    public boolean delete(Long id) {

        if (venteRepository.existsById(id))
            {
                venteRepository.deleteById(id);
                return true;
            }
        else
            {
                return false;
            }

    }


//DELETE ALL
    public boolean deleteAll() {

        if (venteRepository != null)
            {
                venteRepository.deleteAll();
                return  true;
            }
        else
        {
            return false;
        }
    }
}
