package validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class EmployeesDataValidator {
    private static final String SEPARATOR = ";";

    public static List<String> validate(Stream<String> lines) {

        var errors = new HashSet<String>();

        var stringLines = lines.toList();

        var correctLines = new ArrayList<String>();

        int counter = 1;
        for (String stringLine : stringLines) {
            String[] data = stringLine.split(SEPARATOR);

            List<Boolean> ruleIsValidResults = List.of(
                    new EmployeeNameLess120Symbols().isValid(data[0], errors),
                    new EmployeeDateNotNewerCurrentValidator().isValid(data[1], errors),
                    new SalaryIsMultipleOf100Validator().isValid(data[2], errors)
            );

            if (ruleIsValidResults.contains(false)) {
                printError(errors, counter);
            } else {
                correctLines.add(stringLine);
            }
            counter++;
        }

        return correctLines;
    }

    private static void printError(Set<String> errors, int counter) {
        var sb = new StringBuilder();
        sb.append(counter).append(": ");
        errors.forEach(e -> {
            sb.append(e).append("; ");
        });
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
