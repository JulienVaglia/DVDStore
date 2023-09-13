package com.simplon.dvdstore.services;

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
    DvdStoreRepository dvdModelRepository;

// CREATE
    public boolean add(DvdServiceModel dvdServiceModel)
        {
            DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel( dvdServiceModel.getName(), dvdServiceModel.getGenre());
            DvdRepositoryModel dvdRepositoryModelReturned = dvdModelRepository.save( dvdRepositoryModel);

            return dvdRepositoryModelReturned != null ;
        }
// GET ALL

    public ArrayList<DvdServiceModel> findAll()
        {
            ArrayList<DvdServiceModel> dvdModelService = new ArrayList<>();
            ArrayList<DvdRepositoryModel> dvdRepositoryModelArrayList = dvdModelRepository.findAll();
            for(DvdRepositoryModel x: dvdRepositoryModelArrayList){
                dvdModelService.add(new DvdServiceModel(Optional.ofNullable(x.getId()),x.getName(),x.getGenre()));
            }

            return dvdModelService;
        }


    public DvdServiceModel findById(Long id) {
        return DvdStoreRepository.findById(id).orElse(null);
    }
}

