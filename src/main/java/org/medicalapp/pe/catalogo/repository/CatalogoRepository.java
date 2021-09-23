package org.medicalapp.pe.catalogo.repository;

import org.medicalapp.pe.catalogo.domain.Catalogo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CatalogoRepository extends ReactiveCrudRepository<Catalogo, String> {
    Flux<Catalogo> findCatalogoByDesCatalogo(String desCatalogo);
}
