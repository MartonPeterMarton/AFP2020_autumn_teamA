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
@RequestMapping(value = "/id")
@RequiredArgsConstructor
@Api(tags = "ID")
@Slf4j
public class IdController {

    private final IdService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            IdRecordRequestDto request
    ){
        log.info("Recording of ID {}",request.getId());
        try {
            service.record(new Id(request.getId()));
        } catch (IdAlreadyExistsException e) {
            log.info("ID {} already exists! Message: {}", request.getId(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query ID")
    public Collection<IdDto> query(){
        return service.readAll().stream().map(model ->
                IdDto.builder()
                .id(model.getId())
                .build()
        ).collect(Collectors.toList());
    }

}
