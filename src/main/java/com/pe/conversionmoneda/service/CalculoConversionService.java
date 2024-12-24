package com.pe.conversionmoneda.service;

import com.pe.conversionmoneda.dto.CalculoConversionDtoRequest;
import com.pe.conversionmoneda.dto.CalculoConversionDtoResponse;
import reactor.core.publisher.Mono;

public interface CalculoConversionService {

    Mono<CalculoConversionDtoResponse> calculoConversion(CalculoConversionDtoRequest request);
}
