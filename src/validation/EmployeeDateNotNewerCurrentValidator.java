package validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EmployeeDateNotNewerCurrentValidator implements EmployeeRule {

    @Override
    public boolean isValid(String data, Set<String> errors) {
        String description = "Дата приема на работу новее текущей";
        if (LocalDate.parse(data, DateTimeFormatter.ofPattern("dd.MM.yyyy")).isAfter(LocalDate.now())) {
            errors.add(description);
            return false;
        }
        return true;
    }
}
