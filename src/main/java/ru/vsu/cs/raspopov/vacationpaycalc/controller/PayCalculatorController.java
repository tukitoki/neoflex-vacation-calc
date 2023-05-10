package ru.vsu.cs.raspopov.vacationpaycalc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.raspopov.vacationpaycalc.controller.api.PayCalculatorApi;
import ru.vsu.cs.raspopov.vacationpaycalc.service.PayCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class PayCalculatorController implements PayCalculatorApi {

    private final PayCalculatorService payCalculatorService;

    @Override
    @GetMapping("/calculate")
    public BigDecimal calculateVacationPay(@RequestParam BigDecimal averageSalary,
                                           @RequestParam int numberOfVacationDays,
                                           @RequestParam(required = false) LocalDate startVacationDay) {
        return payCalculatorService.calculateVacationPay(averageSalary, numberOfVacationDays, startVacationDay);
    }
}
