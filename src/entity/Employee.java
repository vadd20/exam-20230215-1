package entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String name;
    private LocalDate employmentDate;
    private int salary;
    private long experience;

    private Employee(String name, LocalDate employmentDate, int salary) {
        this.name = name;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.experience = Period.between(employmentDate, LocalDate.now()).toTotalMonths();
    }

    public static Employee buildNewEmployee(String[] data) {
        return new Employee(
                data[0],
                LocalDate.parse(data[1], DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                Integer.parseInt(data[2])
        );
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public long getExperience() {
        return experience;
    }
}
