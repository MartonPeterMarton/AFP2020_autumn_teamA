package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.ComplexNumberDto;
import hu.uni.eku.tzs.controller.dto.ComplexNumberRecordRequestDto;
import hu.uni.eku.tzs.model.ComplexNumber;
import hu.uni.eku.tzs.service.ComplexNumberService;
import hu.uni.eku.tzs.service.exceptions.ComplexNumberAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/azonosito")
@RequiredArgsConstructor
@Api(tags = "AZONISITO")
@Slf4j
public class AzonositoController {

    private final AzonositoService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    AzonositoRecordRequestDto request
    ){
        log.info("Recording of Azonosito {}",request.getAzonosito());
        try {
            service.record(new Azonosito(request.getAzonosito()));
        } catch (AzonositoAlreadyExistsException e) {
            log.info("Azonosito {} already exists! Message: {}", request.getAzonosito(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Azonosito")
    public Collection<AzonositoDto> query(){
        return service.readAll().stream().map(model ->
                AzonositoDto.builder()
                .azonosito(model.getAzonosito())
                .build()
        ).collect(Collectors.toList());
    }

}
