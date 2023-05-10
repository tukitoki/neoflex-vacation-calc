package ru.vsu.cs.raspopov.vacationpaycalc.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Validated
public interface PayCalculatorService {

    BigDecimal calculateVacationPay(@Positive(message = "Average salary should be >0") BigDecimal averageSalary,
                                    @Positive(message = "Vacation days should be >0") int numberOfVacationDays,
                                    LocalDate startVacationDay);
}
