package com.pma.salarycalculator.controller;

import com.pma.salarycalculator.using.VacationCalculationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VacationCalculatorController.class)
public class VacationCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VacationCalculatorService vacationCalculatorService;

    @Test
    public void testCalculateVacation() throws Exception {
        VacationCalculationRequest request = new VacationCalculationRequest(1200.0, 20, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 20));
        Double expectedVacationSum = 16800.0;
        when(vacationCalculatorService.calculateVacationSum(request)).thenReturn(expectedVacationSum);

        mockMvc.perform(MockMvcRequestBuilders.get("/vacation/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"averageSalary\": 1200.0, \"vacationDays\": 20, \"startDate\": \"2024-01-01\", \"endDate\": \"2024-01-20\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("Сумма отпускных: 16800.0"));
    }


}

