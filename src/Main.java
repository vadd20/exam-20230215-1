import entity.Employee;
import io.DataLoader;
import io.DataWriter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Employee> employeesFromFile = DataLoader.readEmployeeData();
        var processor = new DataProcessor();
        List<Employee> result = processor.process(employeesFromFile);
        DataWriter.write(result);
    }
}