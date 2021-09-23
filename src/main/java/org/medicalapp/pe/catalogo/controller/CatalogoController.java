package org.medicalapp.pe.catalogo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.medicalapp.pe.catalogo.controller.mapper.CatalogoControllerMapper;
import org.medicalapp.pe.catalogo.service.CatalogoService;
import org.medicalapp.pe.catalogo.ws.rest.CatalogosApiDelegate;
import org.medicalapp.pe.catalogo.ws.rest.model.DuoDTOControllerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CatalogoController implements CatalogosApiDelegate {

    private final CatalogoService catalogoService;
    private final CatalogoControllerMapper controllerMapper;

    @Override
    public Mono<ResponseEntity<Flux<DuoDTOControllerDto>>> obtenerCatalogos(String id, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok(catalogoService.findCatalogo(id)
                .map(controllerMapper::convertOpcionToDuoDTO)));
    }
}
