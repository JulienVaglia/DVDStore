package com.simplon.dvdstore.controllers.dvd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.simplon.dvdstore.exceptions.NotFoundExection;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


/**
 * The type Dvd store controller.
 */
@RestController // donnees json ou xml
@RequestMapping("api/dvds")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DvdStoreController {

    /**
     * The Dvd store service.
     */
    @Autowired
    DvdStoreService dvdStoreService;


    /**
     * Add boolean.
     *
     * @param dvdStoreDTO the dvd store dto
     * @return the boolean
     */
// CREATE
    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public boolean add( @RequestBody DvdStoreDTO dvdStoreDTO )
        {
            System.out.println(dvdStoreDTO.toString());
            DvdServiceModel dvdServiceModel = new DvdServiceModel(
                    dvdStoreDTO.name(),
                    dvdStoreDTO.genre(),
                    dvdStoreDTO.quantity(),
                    dvdStoreDTO.price(),
                    dvdStoreDTO.photo(),
                    dvdStoreDTO.description());

            return dvdStoreService.add(dvdServiceModel);
        }


    /**
     * Find all array list.
     *
     * @return the array list
     */
//GET ALL
    @GetMapping
    public ArrayList<DvdStoreGetDTO> findAll()
        {
            ArrayList<DvdStoreGetDTO> dvdStoreGetDTOList = new ArrayList<>(); // Création d'une liste vide de la couche supérieure
            ArrayList<DvdServiceModel> dvdServiceModelsArrayList =  dvdStoreService.findAll(); // Création d'une liste qui va récupérer les paramètres du modèle
            for(DvdServiceModel x: dvdServiceModelsArrayList){ // Boucle sur les paramètres à récupérer
                dvdStoreGetDTOList.add(new DvdStoreGetDTO(
                        x.getId().get(),
                        x.getName(),
                        x.getGenre(),
                        x.getQuantity(),
                        x.getPrice(),
                        x.getPhoto(),
                        x.getDescription()));
            }

            return dvdStoreGetDTOList;
        }


    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
// GET ONE
    @GetMapping ("/{id}")
    public ResponseEntity<DvdStoreGetDTO> findById(@PathVariable Long id)
        {
            DvdServiceModel dvdServiceModel = dvdStoreService.findById(id);

            if (dvdServiceModel != null) {
                DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(
                        dvdServiceModel.getId().get(),
                        dvdServiceModel.getName(),
                        dvdServiceModel.getGenre(),
                        dvdServiceModel.getQuantity(),
                        dvdServiceModel.getPrice(),
                        dvdServiceModel.getPhoto(),
                        dvdServiceModel.getDescription()
                );
                return new ResponseEntity<>(dvdStoreGetDTO, HttpStatus.OK);
            } else {
                throw new NotFoundExection(id);
            }
        }

    /**
     * Handle custom not found exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
// Gérez l'exception personnalisée avec @ExceptionHandler
    @ExceptionHandler(NotFoundExection.class)
    public ResponseEntity<String> handleCustomNotFoundException(NotFoundExection ex)
        {
            return new ResponseEntity<>(ex.getMessage(),ex.getStatusCode());
        }


    /**
     * Update boolean.
     *
     * @param id          the id
     * @param dvdStoreDTO the dvd store dto
     * @return the boolean
     */
// UPDATE
    @PutMapping ("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public boolean update(@PathVariable("id") Optional<Long> id, @RequestBody DvdStoreDTO dvdStoreDTO)
        {
            // mapper dto en service
            DvdServiceModel dvdServiceModel = new DvdServiceModel(
                    id,
                    dvdStoreDTO.name(),
                    dvdStoreDTO.genre(),
                    dvdStoreDTO.quantity(),
                    dvdStoreDTO.price(),
                    dvdStoreDTO.photo(),
                    dvdStoreDTO.description());

            return dvdStoreService.update(dvdServiceModel);

        }


    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
// DELETE ONE
@DeleteMapping("/{id}")
@PreAuthorize("hasAuthority('admin')")
public boolean delete(@PathVariable("id") Long id)
    {
        return dvdStoreService.delete(id);
    }




    /**
     * Delete all string.
     *
     * @return the string
     */
// DELETE ALL
@DeleteMapping("/")
@PreAuthorize("hasAuthority('admin')")
public String deleteAll()
    {
        return dvdStoreService.deleteAll();
    }

}
