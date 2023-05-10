package ru.vsu.cs.raspopov.vacationpaycalc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vsu.cs.raspopov.vacationpaycalc.service.impl.PayCalculatorServiceImpl;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PayCalculatorServiceTests {

    private static final double DELTA = 0.2;
    @InjectMocks
    private PayCalculatorServiceImpl payCalculatorService;

    @Test
    void calculateVacationPayTest() {
        BigDecimal averageSalary = BigDecimal.valueOf(20000);
        int numberOfVacationDays = 31;
        BigDecimal expected = BigDecimal.valueOf(21160.29);
        BigDecimal vacationPay = payCalculatorService
                .calculateVacationPay(averageSalary, numberOfVacationDays, null);

        Assertions.assertEquals(expected.doubleValue(), vacationPay.doubleValue(), DELTA);

        averageSalary = BigDecimal.valueOf(36666.67);
        numberOfVacationDays = 31;
        expected = BigDecimal.valueOf(38794.02);
        vacationPay = payCalculatorService
                .calculateVacationPay(averageSalary, numberOfVacationDays, null);

        Assertions.assertEquals(expected.doubleValue(), vacationPay.doubleValue(), DELTA);

        averageSalary = BigDecimal.valueOf(52000);
        numberOfVacationDays = 31;
        expected = BigDecimal.valueOf(55016.94);
        vacationPay = payCalculatorService
                .calculateVacationPay(averageSalary, numberOfVacationDays, null);

        Assertions.assertEquals(expected.doubleValue(), vacationPay.doubleValue(), DELTA);

        averageSalary = BigDecimal.valueOf(30000);
        numberOfVacationDays = 14;
        expected = BigDecimal.valueOf(14334.46);
        vacationPay = payCalculatorService
                .calculateVacationPay(averageSalary, numberOfVacationDays, null);

        Assertions.assertEquals(expected.doubleValue(), vacationPay.doubleValue(), DELTA);
    }
}
