package io;

import entity.Employee;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class DataWriter {
    private static final String RESULT_FILENAME = "data\\result.txt";

    private static final String SEPARATOR = ";";

    public static void write(List<Employee> employees) throws IOException {
        try (var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESULT_FILENAME)))) {
            for (Employee employee : employees) {
                var sb = new StringBuilder()
                        .append(employee.getName()).append(SEPARATOR)
                        .append(employee.getExperience()).append(SEPARATOR)
                        .append(employee.getSalary());
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }
}
