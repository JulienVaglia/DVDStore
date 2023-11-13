package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Dvd store service.
 */
@Service
public class DvdStoreService {

    /**
     * The Dvd store repository.
     */
    @Autowired
    DvdStoreRepository dvdStoreRepository;


    /**
     * Add boolean.
     *
     * @param dvdServiceModel the dvd service model
     * @return the boolean
     */
// CREATE
    public boolean add(DvdServiceModel dvdServiceModel) {
        if (dvdServiceModel.getName() != null && dvdServiceModel.getGenre() != null) {
            DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(
                    dvdServiceModel.getName(),
                    dvdServiceModel.getGenre(),
                    dvdServiceModel.getQuantity(),
                    dvdServiceModel.getPrice(),
                    dvdServiceModel.getPhoto(),
                    dvdServiceModel.getDescription());

            DvdRepositoryModel dvdRepositoryModelReturned = null;
            try {
                dvdRepositoryModelReturned = dvdStoreRepository.save(dvdRepositoryModel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return dvdRepositoryModelReturned != null;
        }
        return false;
    }

    /**
     * Find all array list.
     *
     * @return the array list
     */
// GET ALL
    public ArrayList<DvdServiceModel> findAll()
        {
            ArrayList<com.simplon.dvdstore.services.dvd.DvdServiceModel> dvdModelService = new ArrayList<>();
            ArrayList<DvdRepositoryModel> dvdRepositoryModelArrayList = dvdStoreRepository.findAll();
            for(DvdRepositoryModel x: dvdRepositoryModelArrayList){
                dvdModelService.add(new com.simplon.dvdstore.services.dvd.DvdServiceModel(
                        Optional.ofNullable(x.getId()),
                        x.getName(),
                        x.getGenre(),
                        x.getQuantity(),
                        x.getPrice(),
                        x.getPhoto(),
                        x.getDescription()));
            }

            return dvdModelService;
        }


    /**
     * Find by id dvd service model.
     *
     * @param id the id
     * @return the dvd service model
     */
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
                            dvdRepositoryModel.get().getPhoto(),
                            dvdRepositoryModel.get().getDescription());
            }
    }


    /**
     * Update boolean.
     *
     * @param dvdServiceModel the dvd service model
     * @return the boolean
     */
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
                        dvdServiceModel.getPhoto(),
                        dvdServiceModel.getDescription());

                DvdRepositoryModel updateDvdRepositoryModel = dvdStoreRepository.save(dvdRepositoryModel);

                return updateDvdRepositoryModel != null ;
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
// DELETE
    public boolean delete(Long id) {

        if (dvdStoreRepository.existsById(id))
            {
                dvdStoreRepository.deleteById(id);
                return true;
            }

        return false;

    }


    /**
     * Delete all string.
     *
     * @return the string
     */
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

