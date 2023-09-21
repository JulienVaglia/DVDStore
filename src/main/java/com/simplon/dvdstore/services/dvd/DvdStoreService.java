package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdStoreRepository;


// CREATE
    public boolean add(DvdServiceModel dvdServiceModel)
        {
            DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(
                    dvdServiceModel.getName(),
                    dvdServiceModel.getGenre(),
                    dvdServiceModel.getQuantity(),
                    dvdServiceModel.getPrice(),
                    dvdServiceModel.getPhoto());

            DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save( dvdRepositoryModel);

            return dvdRepositoryModelReturned != null ;
        }



// GET ALL
    public ArrayList<DvdServiceModel> findAll()
        {
            ArrayList<DvdServiceModel> dvdModelService = new ArrayList<>();
            ArrayList<DvdRepositoryModel> dvdRepositoryModelArrayList = dvdStoreRepository.findAll();
            for(DvdRepositoryModel x: dvdRepositoryModelArrayList){
                dvdModelService.add(new DvdServiceModel(
                        Optional.ofNullable(x.getId()),
                        x.getName(),
                        x.getGenre(),
                        x.getQuantity(),
                        x.getPrice(),
                        x.getPhoto()));
            }

            return dvdModelService;
        }


// GET ONE
    public DvdServiceModel findById(Long id) {

        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if (dvdRepositoryModel.isEmpty())
            {
                return null;
            }
        else
            {
                return new DvdServiceModel(
                        Optional.ofNullable(
                            dvdRepositoryModel.get().getId()),
                            dvdRepositoryModel.get().getName(),
                            dvdRepositoryModel.get().getGenre(),
                            dvdRepositoryModel.get().getQuantity(),
                            dvdRepositoryModel.get().getPrice(),
                            dvdRepositoryModel.get().getPhoto());
            }
    }


//UPDATE
    public boolean update(DvdServiceModel dvdServiceModel) {

        if (dvdStoreRepository.existsById(dvdServiceModel.getId().get()))
            {
                DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(
                        dvdServiceModel.getId().get(),
                        dvdServiceModel.getName(),
                        dvdServiceModel.getGenre(),
                        dvdServiceModel.getQuantity(),
                        dvdServiceModel.getPrice(),
                        dvdServiceModel.getPhoto());

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

