package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/cart")
@AllArgsConstructor
public class FeignClientController {

    private final MicroservicePanierProxy panierProxy;


    @GetMapping("/{id}")
    PanierDvdFeignBean findById (@PathVariable("id") Long id)
    {
        return panierProxy.findById(id);
    }

    @GetMapping
    public ArrayList<PanierDvdGetDTO> findAll(){
        return panierProxy.findAll();
    }

}
