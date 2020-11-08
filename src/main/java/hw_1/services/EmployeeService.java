package hw_1.services;

import hw_1.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;

public interface EmployeeService {
    default boolean validateEmployee(Employee employee){
        boolean validated = false;
        String fileName = employee.getId() + ".txt";

        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while((line = reader.readLine()) != null) {
                String[] data = line.split("=", 2);
                if (data[0].equals("email")) {
                    System.out.println("EmployeeService: employee ID=" + employee.getId() + " validated");
                    validated = (data[1].equals(employee.getEmail()));
                }
            }

            reader.close();
        } catch(Exception e) {
            System.out.println("EmployeeService: error reading file " + fileName + " " + e.getMessage());
        }

        return validated;
    }

    void saveEmployee(Employee employee);

}
