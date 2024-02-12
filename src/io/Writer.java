package io;

import entity.EmployeeWithExperience;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Writer {
    private static final String RESULT_FILENAME = "src\\result.txt";

    private static final String SEPARATOR = ";";

    public static void write(List<EmployeeWithExperience> employees) throws IOException {
        try (var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESULT_FILENAME)))) {
            for (EmployeeWithExperience employee : employees) {
                var sb = new StringBuilder()
                        .append(employee.name()).append(SEPARATOR)
                        .append(employee.experience()).append(SEPARATOR)
                        .append(employee.salary());
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }
}
