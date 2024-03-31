package com.pma.salarycalculator.controller;

import com.pma.salarycalculator.using.VacationCalculationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vacation")
public class VacationCalculatorController {
    private final VacationCalculatorService vacationCalculatorService;

    @Autowired
    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<String> calculateVacation(@RequestBody VacationCalculationRequest request) {
        Double vacationSum = vacationCalculatorService.calculateVacationSum(request);
        return ResponseEntity.ok("Сумма отпускных: " + vacationSum);
    }

}


