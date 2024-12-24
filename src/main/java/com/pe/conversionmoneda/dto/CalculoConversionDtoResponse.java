package com.pe.conversionmoneda.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculoConversionDtoResponse {

    private String monedaOrigen;
    private String monedaDestino;
    private Double montoOrigen;
    private Double montoDestino;
}
