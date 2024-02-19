package io;

import entity.Employee;
import validation.EmployeesDataValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
            return lines
                    .map(line -> line.split(SEPARATOR))
                    .filter(EmployeesDataValidator::validate)
                    .map(Employee::buildNewEmployee)
                    .toList();
        }
    }

}
