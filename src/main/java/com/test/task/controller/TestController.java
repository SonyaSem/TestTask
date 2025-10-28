package com.test.task.controller;

import com.test.task.dto.ResponseDTO;
import com.test.task.utils.Sort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "TestController", description = "")
@RestController
public class TestController {

    @Operation(summary = "Получение n-ого минимального числа из файла")
    @GetMapping("/number")
    public ResponseEntity<ResponseDTO> getNumber(
            @RequestParam("path") @Parameter(description = "Путь к файлу", required = true)
            @Validated @NotNull @NotEmpty String path,
            @RequestParam("number") @Parameter(description = "N-ое число", required = true)
            @Validated @NotNull @NumberFormat @Min(1) Integer number
            ) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDTO.builder()
                        .minValue(Sort.getMimNumber(path, number))
                        .build());
    }

}
