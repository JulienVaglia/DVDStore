package com.simplon.dvdstore.repositories.categories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * The interface Categorie repository.
 */
public interface CategorieRepository  extends CrudRepository<CategorieRepositoryModel, Long> {

    ArrayList<CategorieRepositoryModel> findAll();

}
