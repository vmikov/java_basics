package hw_1.services;

import hw_1.entities.Employee;
import java.io.FileWriter;

public class AdminService implements EmployeeService {
    @Override
    public void saveEmployee(Employee employee) {
        String lf = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder("id=" + employee.getId() + lf);

        sb.append("firstName=" + employee.getFirstName() + lf);
        sb.append("lastName=" + employee.getLastName() + lf);
        sb.append("age=" + employee.getAge() + lf);
        sb.append("email=" + employee.getEmail() + lf);

        try {
            FileWriter writer = new FileWriter(employee.getId() + ".txt");

            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("AdminService: error saving employee " + e.getMessage());
        }
    }
}
