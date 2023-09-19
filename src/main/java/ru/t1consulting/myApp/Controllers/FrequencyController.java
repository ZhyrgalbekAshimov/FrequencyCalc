package ru.t1consulting.myApp.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.t1consulting.myApp.Dto.BadRequestResponse;
import ru.t1consulting.myApp.Dto.FrequencyRequest;
import ru.t1consulting.myApp.Dto.FrequencyResponse;
import ru.t1consulting.myApp.service.FrequencyService;

import java.util.List;

@Validated
@RestController
@RequestMapping
public class FrequencyController {
    private final FrequencyService frequencyService;

    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @Operation(summary = "", description = "", tags = {"controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FrequencyResponse.class))),

            @ApiResponse(responseCode = "400", description = "bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class)))})
    @RequestMapping(value = "/calculate-frequency",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)

    public ResponseEntity<FrequencyResponse> calculateFrequency(@Parameter(in = ParameterIn.DEFAULT, description = "Принимает json c массивом текстовых данных", required = true, schema = @Schema()) @Valid @RequestBody FrequencyRequest body) {
        List<String> inputTexts = body.getInput().stream().toList();

        FrequencyResponse frequencyResponse = new FrequencyResponse();
        frequencyResponse.setOutput(frequencyService.calculateFrequency(inputTexts));

        return new ResponseEntity<>(frequencyResponse, HttpStatus.OK);
    }

}