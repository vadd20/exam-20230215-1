package validation;

import java.util.Set;

public class SalaryIsMultipleOf100Validator implements EmployeeRule{
    @Override
    public boolean isValid(String data, Set<String> errors) {
        String description = "Сумма оклада не кратна 100";
        if (Integer.parseInt(data) % 100 != 0) {
            errors.add(description);
            return false;
        }
        return true;
    }
}
