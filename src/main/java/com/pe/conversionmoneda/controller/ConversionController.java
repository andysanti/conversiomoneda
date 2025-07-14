package com.pe.conversionmoneda.controller;

import com.pe.conversionmoneda.dto.CalculoConversionDtoRequest;
import com.pe.conversionmoneda.dto.CalculoConversionDtoResponse;
import com.pe.conversionmoneda.service.CalculoConversionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("v1/conversion")
public class ConversionController {

    Logger logger = LoggerFactory.getLogger(ConversionController.class);
    private final CalculoConversionService calculoRemesaService;

    public ConversionController(CalculoConversionService calculoRemesaService) {
        this.calculoRemesaService = calculoRemesaService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Mono<CalculoConversionDtoResponse>> getCalculoRemesa(@Valid @RequestBody CalculoConversionDtoRequest request){
        logger.info("inicio llamada para conversion {}",request.toString());
        return new ResponseEntity<>(calculoRemesaService.calculoConversion( request), HttpStatus.OK);
    }
}
