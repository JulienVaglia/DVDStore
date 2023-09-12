package com.simplon.dvdstore.dvdstore;

import com.simplon.dvdstore.dvdstore.repositories.DvdModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Data
public class DvdStoreModel {

    List<DvdModel> dvds = new ArrayList <> ();

}
