package com.simplon.dvdstore.controllers;


import com.simplon.dvdstore.exections.NotFoundExection;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


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
    public ResponseEntity<DvdStoreGetDTO> findById(@PathVariable Long id)
        {
            DvdServiceModel dvdServiceModel = dvdStoreService.findById(id);

            if (dvdServiceModel != null) {
                DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(
                        dvdServiceModel.getId().get(),
                        dvdServiceModel.getName(),
                        dvdServiceModel.getGenre()
                );
                return new ResponseEntity<>(dvdStoreGetDTO, HttpStatus.OK);
            } else {
                throw new NotFoundExection(id);
            }
        }

    // Gérez l'exception personnalisée avec @ExceptionHandler
    @ExceptionHandler(NotFoundExection.class)
    public ResponseEntity<String> handleCustomNotFoundException(NotFoundExection ex)
        {
            return new ResponseEntity<>(ex.getMessage(),ex.getStatusCode());
        }


// UPDATE
    @PutMapping ("/{id}")
    public boolean update(@PathVariable("id") Optional<Long> id, @RequestBody DvdStoreDTO dvdStoreDTO)
    {
        // mapper dto en service
        DvdServiceModel dvdServiceModel = new DvdServiceModel(id,dvdStoreDTO.name(),dvdStoreDTO.genre());

        return dvdStoreService.update(dvdServiceModel);

    }

    // Gérez l'exception personnalisée avec @ExceptionHandler
    @ExceptionHandler(NotFoundExection.class)
    public ResponseEntity<String> updateHandleCustomNotFoundException(NotFoundExection ex)
    {
        return new ResponseEntity<>(ex.getMessage(),ex.getStatusCode());
    }


// DELETE ONE
@DeleteMapping("/{id}")
public boolean delete(@PathVariable("id") Long id)
{
    return dvdStoreService.delete(id);
}


// DELETE ALL
@DeleteMapping("/")
public String deleteAll()
{
    return dvdStoreService.deleteAll();
}



}
