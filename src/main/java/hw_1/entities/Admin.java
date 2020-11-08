package hw_1.entities;

public class Admin extends Employee {
    public Admin(long id, String firstName, String lastName, short age, String email) {
        super(id, firstName, lastName, age, email);
        this.setRole(EmployeeRole.ADMIN);
    }
}
