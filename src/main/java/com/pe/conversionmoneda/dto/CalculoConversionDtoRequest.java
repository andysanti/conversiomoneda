package com.pe.conversionmoneda.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculoConversionDtoRequest {

    @NotEmpty
    private String monedaOrigen;
    @NotEmpty
    private String monedaDestino;
    @NotNull
    private Double montoOrigen;

}
