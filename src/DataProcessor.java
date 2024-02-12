import entity.Employee;
import entity.EmployeeWithExperience;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessor {
    public List<EmployeeWithExperience> process(List<Employee> employees) {
        return employees.stream()
                .filter(e -> Period.between(e.employmentDate(), LocalDate.now()).getYears() < 3)
                .map(e -> new EmployeeWithExperience(
                        e.name(),
                        Period.between(e.employmentDate(), LocalDate.now()).getMonths(),
                        e.salary()))
                .sorted(Comparator.comparingInt(EmployeeWithExperience::experience))
                .collect(Collectors.toList());
    }
}
