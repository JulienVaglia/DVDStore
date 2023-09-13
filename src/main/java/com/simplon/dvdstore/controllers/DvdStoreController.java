package com.simplon.dvdstore.controllers;


import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller


@RestController // donnees json ou xml
@RequestMapping("dvds")
@NoArgsConstructor
public class DvdStoreController {




    @Autowired
    DvdStoreService dvdStoreService;


// CREATE
    @PostMapping  //
    public boolean add(@RequestBody DvdStoreDTO dvdStoreDTO )
        {
            DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.name(), dvdStoreDTO.genre());

            return dvdStoreService.add(dvdServiceModel);
        }
//GET ALL
    @GetMapping
    public ArrayList<DvdStoreGetDTO> findAll(){
        ArrayList<DvdStoreGetDTO> dvdStoreGetDTOList = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModelsArrayList =  dvdStoreService.findAll();
        for(DvdServiceModel x: dvdServiceModelsArrayList){
            dvdStoreGetDTOList.add(new DvdStoreGetDTO(x.getId().get(), x.getName(),x.getGenre()));
        }

        return dvdStoreGetDTOList;
    }


// GET ONE
    @GetMapping ("/{id}")
    public ResponseEntity<DvdStoreGetDTO> findById(@PathVariable Long id) {
        DvdServiceModel dvdServiceModel = dvdStoreService.findById(id);

        if (dvdServiceModel != null) {
            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(
                    dvdServiceModel.getId().get(),
                    dvdServiceModel.getName(),
                    dvdServiceModel.getGenre()
            );
            return new ResponseEntity<>(dvdStoreGetDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



// UPDATE

// DELETE ALL

// DELETE ONE


}
