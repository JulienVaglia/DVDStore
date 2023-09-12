package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdModel;
import com.simplon.dvdstore.dvdstore.services.DvdModelService;
import com.simplon.dvdstore.dvdstore.services.DvdStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller qui ne peut accepter que du JSON ou XML
@RequiredArgsConstructor
@RequestMapping("dvdstore")
public class DvdStoreController {

    @Autowired
    DvdStoreService dvdStoreService;

    @PostMapping
    public DvdModel addDvdStore(@RequestBody DvdModelService dvdModelService)
        {
            return dvdStoreService.addDvdStore(dvdModelService);
        }



}
