package com.pe.conversionmoneda.dominio;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Conversion {

    private String monedaOrigen;
    private String monedaDestino;
    private Double tasaCambio;

}
