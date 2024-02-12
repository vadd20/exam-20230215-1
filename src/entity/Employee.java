package entity;

import java.time.LocalDate;

public record Employee(String name, LocalDate employmentDate, Integer salary) {
}
