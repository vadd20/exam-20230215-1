package validation;

import java.util.Set;

public interface EmployeeRule {
    boolean isValid(String data, Set<String> errors);
}
