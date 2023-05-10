package ru.vsu.cs.raspopov.vacationpaycalc.service.impl;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import org.springframework.stereotype.Service;
import ru.vsu.cs.raspopov.vacationpaycalc.service.PayCalculatorService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class PayCalculatorServiceImpl implements PayCalculatorService {

    private final static double AVERAGE_DAY_IN_MONTH = 29.3;
    private final static int SCALE = 2;

    @Override
    public BigDecimal calculateVacationPay(BigDecimal averageSalary, int numberOfVacationDays,
                                           LocalDate startVacationDay) {

        if (startVacationDay == null) {
            return averageSalary
                    .multiply(BigDecimal.valueOf(numberOfVacationDays))
                    .divide(BigDecimal.valueOf(AVERAGE_DAY_IN_MONTH), SCALE, RoundingMode.CEILING);
        }

        HolidayManager holidayManager = HolidayManager.getInstance(HolidayCalendar.RUSSIA);
        var holidays = holidayManager.getHolidays(startVacationDay, startVacationDay.plusDays(numberOfVacationDays));
        numberOfVacationDays -= holidays.size();

        return averageSalary
                .multiply(BigDecimal.valueOf(numberOfVacationDays))
                .divide(BigDecimal.valueOf(AVERAGE_DAY_IN_MONTH), SCALE, RoundingMode.CEILING);
    }
}
