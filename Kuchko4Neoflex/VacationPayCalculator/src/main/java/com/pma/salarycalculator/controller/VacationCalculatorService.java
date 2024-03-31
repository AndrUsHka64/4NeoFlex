package com.pma.salarycalculator.controller;

import com.pma.salarycalculator.using.HolidayConfiguration;
import com.pma.salarycalculator.using.VacationCalculationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

@Service
public class VacationCalculatorService {

    public Double calculateVacationSum(VacationCalculationRequest request) {
        int workDays = getWorkingDaysBetweenTwoDates(request.getStartDate(), request.getEndDate());
        return request.getAverageSalary() * workDays;
    }

    private int getWorkingDaysBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return (int) IntStream.range(0, (int) ChronoUnit.DAYS.between(startDate, endDate) + 1)
                .filter(i -> {
                    LocalDate date = startDate.plusDays(i);
                    return date.getDayOfWeek().getValue() < 6 && !HolidayConfiguration.isHoliday(date);
                })
                .count();
    }

}

