package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdModel;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepositoryInterface dvdStoreRepositoryInterface;


    public DvdModel addDvdStore(DvdModelService dvdModelService) {
        // Mapper les données ( convertir objet de type DvdModelService en type DvdModel pour matcher avec la Base de données )
        DvdModel dvdModel = new DvdModel(dvdModelService.getName(), dvdModelService.getGenre());

        return dvdStoreRepositoryInterface.save(dvdModel);

    }
}
