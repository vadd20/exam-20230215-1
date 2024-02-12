import entity.Employee;
import entity.EmployeeWithExperience;
import io.DataLoader;
import io.Writer;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Employee> employeesFromFile = DataLoader.readEmployeeData();

        var processor = new DataProcessor();
        List<EmployeeWithExperience> result = processor.process(employeesFromFile);

        Writer.write(result);
    }
}