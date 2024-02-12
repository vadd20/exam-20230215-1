package io;

import entity.Employee;
import validation.EmployeesDataValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataLoader {

    private static final String EMPLOYEE_FILENAME = "data\\employees.txt";
    private static final String SEPARATOR = ";";

    /**
     * Чтение сущностей сотрудников из файла.
     *
     * @return список сущностей сотрудников
     * @throws IOException ошибка ввода/вывода
     */
    public static List<Employee> readEmployeeData() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(EMPLOYEE_FILENAME))) {

            List<String> correctLines = EmployeesDataValidator.validate(lines);

            return correctLines.stream()
                    .map(line -> line.split(SEPARATOR))
                    .map(data -> new Employee(
                            data[0],
                            LocalDate.parse(data[1], DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                            Integer.parseInt(data[2])
                    ))
                    .collect(Collectors.toList());
        }
    }
}
