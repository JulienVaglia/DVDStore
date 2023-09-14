package com.simplon.dvdstore.services;

import com.simplon.dvdstore.controllers.DvdStoreDTO;
import com.simplon.dvdstore.controllers.DvdStoreGetDTO;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdStoreRepository;


// CREATE
    public boolean add(DvdServiceModel dvdServiceModel)
        {
            DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel( dvdServiceModel.getName(), dvdServiceModel.getGenre());
            DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save( dvdRepositoryModel);

            return dvdRepositoryModelReturned != null ;
        }



// GET ALL
    public ArrayList<DvdServiceModel> findAll()
        {
            ArrayList<DvdServiceModel> dvdModelService = new ArrayList<>();
            ArrayList<DvdRepositoryModel> dvdRepositoryModelArrayList = dvdStoreRepository.findAll();
            for(DvdRepositoryModel x: dvdRepositoryModelArrayList){
                dvdModelService.add(new DvdServiceModel(Optional.ofNullable(x.getId()),x.getName(),x.getGenre()));
            }

            return dvdModelService;
        }


    public DvdServiceModel findById(Long id) {

        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if (dvdRepositoryModel.isEmpty())
            {
                return null;
            }
        else
            {
                return new DvdServiceModel(Optional.ofNullable(dvdRepositoryModel.get().getId()),dvdRepositoryModel.get().getName(),dvdRepositoryModel.get().getGenre());
            }
    }


//UPDATE
    public boolean update(DvdServiceModel dvdServiceModel) {

        if (dvdStoreRepository.existsById(dvdServiceModel.getId().get()))
            {
                DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdServiceModel.getId().get(), dvdServiceModel.getName(), dvdServiceModel.getGenre());

                DvdRepositoryModel updateDvdRepositoryModel = dvdStoreRepository.save(dvdRepositoryModel);

                return updateDvdRepositoryModel != null ;
            }
        else
            {
                return false;
            }

    }


// DELETE
    public boolean delete(Long id) {

        if (dvdStoreRepository.existsById(id))
            {
                dvdStoreRepository.deleteById(id);
                return true;
            }

        return false;

    }


// DELETE
    public String deleteAll() {

        if (dvdStoreRepository != null)
            {
                dvdStoreRepository.deleteAll();
                return "Base de données supprimée";
            }

        return "Aucun film dans la base de données";
    }

}

