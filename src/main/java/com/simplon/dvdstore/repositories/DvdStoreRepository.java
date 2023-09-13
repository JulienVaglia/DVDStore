package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel,Long>{


    ArrayList<DvdRepositoryModel> findAll();



}
