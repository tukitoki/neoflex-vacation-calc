package ru.vsu.cs.raspopov.vacationpaycalc.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Api(tags = "Pay Calculator API")
public interface PayCalculatorApi {

    @ApiOperation(
            value = "Возвращает количество отпускных"
    )
    BigDecimal calculateVacationPay(
            @ApiParam(value = "Средняя зарплата")
            BigDecimal averageSalary,
            @ApiParam(value = "Количество дней отпуска")
            int numberOfVacationDays,
            @ApiParam(value = "Начало отпуска")
            LocalDate startVacationDay
    );
}
