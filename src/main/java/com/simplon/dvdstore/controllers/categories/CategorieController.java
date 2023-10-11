package com.simplon.dvdstore.controllers.categories;

import com.simplon.dvdstore.services.categories.CategorieService;
import com.simplon.dvdstore.services.categories.CategorieServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Categorie controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/categories")
public class CategorieController {

    /**
     * The Categorie service.
     */
    @Autowired
    CategorieService categorieService;

    /**
     * Add boolean.
     *
     * @param categorieDTO the categorie dto
     * @return the boolean
     */
//CREATE
    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public boolean add( @RequestBody CategorieDTO categorieDTO )
    {
        CategorieServiceModel categorieServiceModel = new CategorieServiceModel(
                categorieDTO.genre());

        return categorieService.add(categorieServiceModel);
    }


    /**
     * Find all array list.
     *
     * @return the array list
     */
//GET ALL
    @GetMapping
    public ArrayList<CategorieGetDTO> findAll()
    {

        ArrayList<CategorieGetDTO> categorieGetDTOArrayList = new ArrayList<>();
        ArrayList<CategorieServiceModel> categorieServiceModelArrayList = categorieService.findAll();
        for (CategorieServiceModel x: categorieServiceModelArrayList){
            categorieGetDTOArrayList.add(new CategorieGetDTO(
                    x.getId().get(),
                    x.getGenre()));
        }

        return categorieGetDTOArrayList;

    }


    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
//GET ONE
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/{id}")
    public ResponseEntity<CategorieGetDTO> findById(@PathVariable Long id){

        CategorieServiceModel categorieServiceModel = categorieService.findById(id);

        if (categorieServiceModel != null)
        {
            CategorieGetDTO categorieGetDTO = new CategorieGetDTO(
                    categorieServiceModel.getId().get(),
                    categorieServiceModel.getGenre()
            );
            return new ResponseEntity<>(categorieGetDTO, HttpStatus.OK);
        }
        else
        {
            return ResponseEntity.badRequest().body(null);
        }
    }


    /**
     * Update boolean.
     *
     * @param id           the id
     * @param categorieDTO the categorie dto
     * @return the boolean
     */
//UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public boolean update(@PathVariable("id") Optional<Long> id, @RequestBody CategorieDTO categorieDTO){

        CategorieServiceModel categorieServiceModel = new CategorieServiceModel(
                id,
                categorieDTO.genre()
);

        return categorieService.update(categorieServiceModel);
    }


    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
//DELETE ONE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public boolean delete(@PathVariable("id") Long id)
    {
        return categorieService.delete(id);
    }


    /**
     * Delete all boolean.
     *
     * @return the boolean
     */
//DELETE ALL
    @DeleteMapping("/")
    @PreAuthorize("hasAuthority('admin')")
    public boolean deleteAll()
    {
        return categorieService.deleteAll();
    }


}
