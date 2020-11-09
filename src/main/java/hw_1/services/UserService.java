package hw_1.services;

import hw_1.entities.Employee;

public class UserService implements EmployeeService {
    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("UserService: saving employee is unavailable");
    }
}
