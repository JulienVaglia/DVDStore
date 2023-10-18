package com.simplon.dvdstore.feignClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDvdFeignBean {

    private Long dvd_id;
    private Long panier_id;
    private Float quantite;

}
