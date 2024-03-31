package com.pma.salarycalculator.using;

import java.time.LocalDate;

public class VacationCalculationRequest {
    private Double averageSalary;
    private Integer vacationDays;
    private LocalDate startDate;
    private LocalDate endDate;

    public VacationCalculationRequest(Double averageSalary, Integer vacationDays, LocalDate startDate, LocalDate endDate) {
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
