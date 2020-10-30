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
@RequestMapping(value = "/slide")
@RequiredArgsConstructor
@Api(tags = "Slide")
@Slf4j
public class SlideController {

    private final SlideService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            SlideRecordRequestDto request
    ){
        log.info("Recording of Slide {}",request.getSlide());
        try {
            service.record(new Slide(request.getSlide()));
        } catch (SlideAlreadyExistsException e) {
            log.info("Slide {} already exists! Message: {}", request.getSlide(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Slide")
    public Collection<SlideDto> query(){
        return service.readAll().stream().map(model ->
                SlideDto.builder()
                .slide(model.getSlide())
                .build()
        ).collect(Collectors.toList());
    }

}
