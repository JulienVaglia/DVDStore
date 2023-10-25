package com.simplon.dvdstore.proxies;

import com.simplon.dvdstore.feignClient.PanierDvdFeignBean;
import com.simplon.dvdstore.feignClient.PanierDvdGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@FeignClient(name="dvdCart", url = "localhost:9002")
public interface MicroservicePanierProxy {

    @GetMapping("/api/panier/{id}")
    PanierDvdFeignBean findById(@PathVariable("id")Long id);

    @GetMapping("/api/panier")
    ArrayList<PanierDvdGetDTO> findAll();

    @PostMapping("/api/panier")
    boolean addDvdPrice(@RequestBody PanierDvdGetDTO panierDvdGetDTO);

}
