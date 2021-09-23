package org.medicalapp.pe.catalogo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.medicalapp.pe.catalogo.domain.Catalogo;
import org.medicalapp.pe.catalogo.repository.CatalogoRepository;
import org.medicalapp.pe.catalogo.service.CatalogoService;
import org.medicalapp.pe.catalogo.service.dto.DuoDTO;
import org.medicalapp.pe.catalogo.service.exceptions.CatalogoNotFoundException;
import org.medicalapp.pe.catalogo.service.exceptions.CatalogoServiceException;
import org.medicalapp.pe.catalogo.service.mapper.CatalogoServiceMapper;
import org.medicalapp.pe.catalogo.util.Constants;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {

    private final CatalogoRepository catalogoRepository;
    private final CatalogoServiceMapper catalogoServiceMapper;

    @Override
    public Flux<DuoDTO> findCatalogo(String desCatalogo) {
        return catalogoRepository.findCatalogoByDesCatalogo(desCatalogo)
                .flatMapIterable(Catalogo::getLisCatalogo)
                .map(catalogoServiceMapper::convertOpcionToDuoDTO)
                .onErrorMap(CatalogoServiceException::new)
                .sort(Comparator.comparing(DuoDTO::getValor))
                .collectList()
                .doOnNext(x -> log.info(Constants.RESULTADOS_OBTENIDOS_TABLAS, x.size(), desCatalogo, "tabladeTablas"))
                .flatMapMany(Flux::fromIterable)
                .switchIfEmpty(Mono.error(new CatalogoNotFoundException(desCatalogo)));
    }
}
