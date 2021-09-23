package org.medicalapp.pe.catalogo.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.medicalapp.pe.catalogo.domain.Catalogo;
import org.medicalapp.pe.catalogo.service.dto.DuoDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatalogoServiceMapper {

    @Mapping(source = "codOpcion", target = "codigo")
    @Mapping(source = "desOpcion", target = "valor")
    DuoDTO convertOpcionToDuoDTO(Catalogo.Opcion opcion);
}
