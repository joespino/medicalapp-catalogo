package org.medicalapp.pe.catalogo.service.exceptions;

public class CatalogoServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    public CatalogoServiceException() {
        super();
    }

    public CatalogoServiceException(String message) {
        super(message);
    }

    public CatalogoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogoServiceException(Throwable cause) {
        super(cause);
    }

    protected CatalogoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
