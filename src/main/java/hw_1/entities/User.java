package hw_1.entities;

public class User extends Employee {
    public User(long id, String firstName, String lastName, short age, String email) {
        super(id, firstName, lastName, age, email);
        setRole(EmployeeRole.USER);
    }
}
