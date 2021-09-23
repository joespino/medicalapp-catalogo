package org.medicalapp.pe.catalogo.service;

import org.medicalapp.pe.catalogo.service.dto.DuoDTO;
import reactor.core.publisher.Flux;

public interface CatalogoService {
    Flux<DuoDTO> findCatalogo(String desCatalogo);
}
