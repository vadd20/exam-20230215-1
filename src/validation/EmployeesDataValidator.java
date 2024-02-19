package validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class EmployeesDataValidator {

    private static int counter = 1;
    public static boolean validate(String[] data) {

        var errors = new HashSet<String>();
        List<Boolean> ruleIsValidResults = List.of(
                new EmployeeNameLess120SymbolsValidator().isValid(data[0], errors),
                new EmployeeDateNotNewerCurrentValidator().isValid(data[1], errors),
                new SalaryIsMultipleOf100Validator().isValid(data[2], errors)
        );

        if (ruleIsValidResults.contains(false)) {
            printError(errors);
            return false;
        }
        return true;
    }


    private static void printError(Set<String> errors) {
        var sb = new StringBuilder();
        sb.append(counter).append(": ");
        errors.forEach(e -> {
            sb.append(e).append("; ");
        });
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
        counter++;
    }
}
