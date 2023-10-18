package com.simplon.dvdstore.proxies;

import com.simplon.dvdstore.feignClient.PanierDvdFeignBean;
import com.simplon.dvdstore.feignClient.PanierDvdGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient(name="dvdCart", url = "localhost:9002")
public interface MicroservicePanierProxy {

    @GetMapping("/api/paniers/{id}")
    PanierDvdFeignBean findById(@PathVariable("id")Long id);

    @GetMapping("/api/paniers")
    ArrayList<PanierDvdGetDTO> findAll();
}
