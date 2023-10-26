package com.simplon.dvdstorecart.mappers;

import com.simplon.dvdstorecart.controllers.panier.PanierGetDTO;
import com.simplon.dvdstorecart.controllers.panierdvd.PanierDvdGetDTO;
import com.simplon.dvdstorecart.repositories.panier.PanierRepositoryModel;
import com.simplon.dvdstorecart.repositories.panierdvd.PanierDvdRepositoryModel;
import com.simplon.dvdstorecart.services.panier.PanierServiceModel;
import com.simplon.dvdstorecart.services.panierdvd.PanierDvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DvdStoreCartMapper {

    DvdStoreCartMapper INSTANCE = Mappers.getMapper(DvdStoreCartMapper.class); // Pour utiliser MapStruck


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//            DTO  ->  Service  -->  Repository
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    PanierDvdServiceModel dtoToService (PanierDvdGetDTO panierGetDTO);

    PanierDvdRepositoryModel serviceToRepository(PanierDvdServiceModel panierServiceModel);


//    PanierServiceModel dtoToService (PanierGetDTO panierGetDTO);
//
//    PanierRepositoryModel serviceToRepository(PanierServiceModel panierServiceModel);




// ------------------------------------------------------------------------------
//             List<Repository>  ->  List<Service>  -->  List<GetDTO>
// ------------------------------------------------------------------------------

    List<PanierDvdServiceModel> arrayListRepositoryToService(List<PanierDvdRepositoryModel> paniers);

    List<PanierDvdGetDTO> arrayListServiceToDTO(List<PanierDvdServiceModel> paniers);


    List<PanierServiceModel> arrayListPanierRepositoryToService(List<PanierRepositoryModel> panier);

//    @Mapping(target = "dvds", ignore = true)
    List<PanierGetDTO> arrayListPanierServiceToDTO(List<PanierServiceModel> all);
// ------------------------------------------------------------------------------
//             Repository  ->  Service  -->  GetDTO
// ------------------------------------------------------------------------------

    //PanierDVD
    PanierDvdGetDTO serviceToDTO(PanierDvdServiceModel panier);
    PanierDvdServiceModel repositoryToService(PanierDvdRepositoryModel panier);


    //Panier
    PanierServiceModel repositoryPanierToService(PanierRepositoryModel panier);
    
    
    
    PanierGetDTO servicePanierToDTO(PanierServiceModel byID, List<PanierDvdRepositoryModel> dvds);

    PanierGetDTO panierServiceToPanierDTO(PanierServiceModel panierRepositoryModel);
}
