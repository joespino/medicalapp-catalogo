package org.medicalapp.pe.catalogo.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.medicalapp.pe.catalogo.service.dto.DuoDTO;
import org.medicalapp.pe.catalogo.ws.rest.model.DuoDTOControllerDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatalogoControllerMapper {

    DuoDTOControllerDto convertOpcionToDuoDTO(DuoDTO opcion);
}
