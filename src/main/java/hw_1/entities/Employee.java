package hw_1.entities;

public abstract class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private short age;
    private String email;
    private EmployeeRole role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public void setName(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    protected Employee(long id, String firstName, String lastName, short age, String email) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setEmail(email);
    }

    @Override
    public String toString() {
        return "{id: " + getId() + ": " + getFirstName() + " " + getLastName() + ", " + getRole() + "}";
    }
}
