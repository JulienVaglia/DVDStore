package com.simplon.dvdstore.controllers.categories;

import com.simplon.dvdstore.services.categories.CategorieService;
import com.simplon.dvdstore.services.categories.CategorieServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    //CREATE
    @PostMapping
    public boolean add( @RequestBody CategorieDTO categorieDTO )
    {
        CategorieServiceModel categorieServiceModel = new CategorieServiceModel(
                categorieDTO.genre());

        return categorieService.add(categorieServiceModel);
    }


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


    //GET ONE
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


    //UPDATE
    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") Optional<Long> id, @RequestBody CategorieDTO categorieDTO){

        CategorieServiceModel categorieServiceModel = new CategorieServiceModel(
                id,
                categorieDTO.genre()
);

        return categorieService.update(categorieServiceModel);
    }


    //DELETE ONE
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id)
    {
        return categorieService.delete(id);
    }


    //DELETE ALL
    @DeleteMapping("/")
    public boolean deleteAll()
    {
        return categorieService.deleteAll();
    }


}
