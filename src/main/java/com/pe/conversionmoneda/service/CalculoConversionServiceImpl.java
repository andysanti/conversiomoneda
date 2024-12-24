package com.pe.conversionmoneda.service;

import com.pe.conversionmoneda.dominio.Conversion;
import com.pe.conversionmoneda.dto.CalculoConversionDtoRequest;
import com.pe.conversionmoneda.dto.CalculoConversionDtoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CalculoConversionServiceImpl implements CalculoConversionService{


    private Flux<Conversion> conversionList = Flux.just(
            Conversion.builder().monedaDestino("USD")
                    .monedaOrigen("PE")
                    .tasaCambio(1/3.70).build(),
                    Conversion.builder().monedaDestino("PE")
                            .monedaOrigen("USD")
                            .tasaCambio(3.70).build()


    );


    @Override
    public Mono<CalculoConversionDtoResponse> calculoConversion(CalculoConversionDtoRequest request) {


        Mono<Conversion> x;
        x = conversionList.filter(conversion -> conversion.getMonedaOrigen().equals(request.getMonedaOrigen()) &&
                conversion.getMonedaDestino().equals(request.getMonedaDestino())).elementAt(0);


        return x.map(conversion -> (CalculoConversionDtoResponse.builder().monedaOrigen(conversion.getMonedaOrigen())
               .monedaDestino(conversion.getMonedaDestino())
               .montoOrigen(request.getMontoOrigen())
               .montoDestino(BigDecimal.valueOf(conversion.getTasaCambio()* request.getMontoOrigen()).setScale(2, RoundingMode.HALF_UP).doubleValue()).build()));

    }
}
