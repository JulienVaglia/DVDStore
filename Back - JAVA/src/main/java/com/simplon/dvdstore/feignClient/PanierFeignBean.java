package com.simplon.dvdstore.feignClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierFeignBean {

    private Long id;
    private Float montant;
    private Date date_validation;
    private Long client$_id;

}
