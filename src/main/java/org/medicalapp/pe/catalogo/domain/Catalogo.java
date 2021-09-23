package org.medicalapp.pe.catalogo.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.medicalapp.pe.spring.core.document.BaseDocument;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document("tabladeTablas")
@EqualsAndHashCode(callSuper = false)
public class Catalogo extends BaseDocument<String> {

    public static final String DOCUMENT_SCHEMA_VERSION = "1.0.0";

    private String codCatalogo;
    private String desCatalogo;
    private Integer indEstadoRegistro;
    @Builder.Default
    private List<Opcion> lisCatalogo = new ArrayList<>();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Opcion {
        private String codOpcion;
        private String desOpcion;
        private String desLargaOpcion;
        private Integer indEstadoRegistro;
    }

    @Override
    protected String getDocumentSchemaVersion() {
        return DOCUMENT_SCHEMA_VERSION;
    }
}
