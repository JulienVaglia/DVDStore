package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public boolean addDvdPrice ( @RequestBody PanierDvdGetDTO panierDvdGetDTO ){
        return panierProxy.addDvdPrice(panierDvdGetDTO);
    }
}
