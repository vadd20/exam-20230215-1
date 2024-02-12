package validation;

import java.util.Set;

public class EmployeeNameLess120Symbols implements EmployeeRule {

    @Override
    public boolean isValid(String data, Set<String> errors) {
        String description = "ФИО сотрудника длинее 120 символов";
        if (data.length() > 120) {
            errors.add(description);
            return false;
        }
        return true;
    }
}
