import entity.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessor {
    public List<Employee> process(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getExperience() < 36)
                .sorted(Comparator.comparingLong(Employee::getExperience))
                .toList();
    }
}
