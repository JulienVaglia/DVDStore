package com.simplon.dvdstore.services.categories;

import com.simplon.dvdstore.repositories.categories.CategorieRepository;
import com.simplon.dvdstore.repositories.categories.CategorieRepositoryModel;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Categorie service.
 */
@Service
public class CategorieService {


    /**
     * The Categorie repository.
     */
    @Autowired
    CategorieRepository categorieRepository;

    /**
     * Add boolean.
     *
     * @param categorieServiceModel the categorie service model
     * @return the boolean
     */
//CREATE
    public boolean add(CategorieServiceModel categorieServiceModel) {

        CategorieRepositoryModel categorieRepositoryModel = new CategorieRepositoryModel(
                categorieServiceModel.getGenre());


        CategorieRepositoryModel categorieRepositoryModelReturned = categorieRepository.save(categorieRepositoryModel);

        return categorieRepositoryModelReturned != null;
    }


    /**
     * Find all array list.
     *
     * @return the array list
     */
//GET ALL
    public ArrayList<CategorieServiceModel> findAll()
    {

        ArrayList<CategorieRepositoryModel> categorieRepositoryModelArrayList = categorieRepository.findAll();
        ArrayList<CategorieServiceModel> categorieServiceModelArrayList = new ArrayList<>();

        for ( CategorieRepositoryModel x: categorieRepositoryModelArrayList ){
            categorieServiceModelArrayList.add(new CategorieServiceModel(
                    Optional.ofNullable(x.getId()),
                    x.getGenre()));
        }
        return categorieServiceModelArrayList;
    }


    /**
     * Find by id categorie service model.
     *
     * @param id the id
     * @return the categorie service model
     */
// GET ONE
    public CategorieServiceModel findById(Long id) {

        Optional<CategorieRepositoryModel> categorieRepositoryModel = categorieRepository.findById(id);

        if ( categorieRepositoryModel.isEmpty())
        {
            return null;
        }
        else
        {
            return new CategorieServiceModel(
                    Optional.ofNullable(categorieRepositoryModel.get().getId()),
                    categorieRepositoryModel.get().getGenre());
        }
    }


    /**
     * Update boolean.
     *
     * @param categorieServiceModel the categorie service model
     * @return the boolean
     */
//UPDATE
    public boolean update(CategorieServiceModel categorieServiceModel) {

        if (categorieRepository != null){

            CategorieRepositoryModel categorieRepositoryModel = new CategorieRepositoryModel(
                    categorieServiceModel.getId().get(),
                    categorieServiceModel.getGenre());

            CategorieRepositoryModel updateCategorieRepositoryModel =  categorieRepository.save(categorieRepositoryModel);
            return updateCategorieRepositoryModel != null;
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
//DELETE ONE
    public boolean delete(Long id) {
        if (categorieRepository.existsById(id))
        {
            categorieRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }

    }


    /**
     * Delete all boolean.
     *
     * @return the boolean
     */
//DELETE ALL
    public boolean deleteAll() {
        if (categorieRepository != null)
        {
            categorieRepository.deleteAll();
            return true;
        }
        else
        {
            return false;
        }
    }



}
