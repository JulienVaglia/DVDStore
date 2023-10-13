package com.simplon.dvdstorecart.mappers;

import com.simplon.dvdstorecart.controllers.paniers.PanierGetDTO;
import com.simplon.dvdstorecart.repositories.paniers.PanierRepositoryModel;
import com.simplon.dvdstorecart.services.paniers.PanierServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

@Mapper
public interface DvdStoreCartMapper {

    DvdStoreCartMapper INSTANCE = Mappers.getMapper(DvdStoreCartMapper.class); // Pour utiliser MapStruck


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//            DTO  ->  Service  -->  Repository
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Mapping(target = "id", ignore = true)
    PanierServiceModel dtoToService (PanierGetDTO panierGetDTO);

    @Mapping(target = "id" , ignore = true)
    PanierRepositoryModel serviceToRepository(PanierServiceModel panierServiceModel);



// ------------------------------------------------------------------------------
//             List<Repository>  ->  List<Service>  -->  List<GetDTO>
// ------------------------------------------------------------------------------
    ArrayList<PanierServiceModel> arrayListRepositoryToService(Iterable<PanierRepositoryModel> paniers);

    ArrayList<PanierGetDTO> arrayListServiceToDTO(ArrayList<PanierServiceModel> paniers);


// ------------------------------------------------------------------------------
//             Repository  ->  Service  -->  GetDTO
// ------------------------------------------------------------------------------

    PanierGetDTO serviceToDTO(PanierServiceModel panier);

    PanierServiceModel repositoryToService(PanierRepositoryModel panier);
}
