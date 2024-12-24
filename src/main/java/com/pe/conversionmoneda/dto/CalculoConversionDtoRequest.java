package com.pe.conversionmoneda.dto;

import lombok.Data;

@Data
public class CalculoConversionDtoRequest {

    private String monedaOrigen;
    private String monedaDestino;
    private Double montoOrigen;

}
