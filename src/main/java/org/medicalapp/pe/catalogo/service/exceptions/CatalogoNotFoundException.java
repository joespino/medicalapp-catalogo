package org.medicalapp.pe.catalogo.service.exceptions;

import org.apache.http.HttpStatus;
import org.medicalapp.pe.spring.webflux.exception.NotFoundException;

public class CatalogoNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;

    /**
     * Simple CatalogoNotFoundException
     *
     */
    public CatalogoNotFoundException() {
        this(HttpStatus.SC_NOT_FOUND, "Catalogo no encontrado");
    }

    /**
     * CatalogoNotFoundException with message
     *
     */
    public CatalogoNotFoundException(String message) {
        this(HttpStatus.SC_NOT_FOUND, String.format("Catalogo no encontrado con la descripcion: %s", message));
    }

    /**
     * CatalogoNotFoundException with code and message
     *
     * @param code codigo utilizado para representar el status del response
     * @param message mensaje que se mostrara en el response
     */
    public CatalogoNotFoundException(int code, String message) {
        super(code, message);
    }
}
