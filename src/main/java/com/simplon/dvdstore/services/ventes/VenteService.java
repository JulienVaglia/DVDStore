package com.simplon.dvdstore.services.ventes;

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
//    public VenteServiceModel findById(Long id) {
//
//        Optional<VenteRepositoryModel> venteRepositoryModel = venteRepository.findById(id);
//
//        DvdServiceModel dvdServiceModel = new DvdServiceModel(
//                Optional.ofNullable(x.getDvdRepositoryModel().getId()),
//                x.getDvdRepositoryModel().getName(),
//                x.getDvdRepositoryModel().getGenre(),
//                x.getDvdRepositoryModel().getQuantity(),
//                x.getDvdRepositoryModel().getPrice(),
//                x.getDvdRepositoryModel().getPhoto(),
//                x.getDvdRepositoryModel().getDescription());
//
//        ClientServiceModel clientServiceModel = new ClientServiceModel(
//                Optional.ofNullable(x.getId()),
//                x.getClientRepositoryModel().getNom(),
//                x.getClientRepositoryModel().getPrenom(),
//                x.getClientRepositoryModel().getAddresse());
//
//        if ( venteRepositoryModel.isEmpty())
//        {
//            return null;
//        }
//        else
//        {
//            return new ClientServiceModel(
//                    Optional.ofNullable(venteRepositoryModel.get().getId()),
//                    venteRepositoryModel.get().getDate(),
//                    venteRepositoryModel.get().getMontant(),
//                    venteRepositoryModel.get().getQuantity(),
//                    venteRepositoryModel.get().getQuantity(),);
//        }
//
//    }



}
