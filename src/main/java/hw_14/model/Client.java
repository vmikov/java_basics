package hw_14.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private BigInteger phone;
    private String about;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Client() {}

    public Client(String name, String email, BigInteger phone, String about, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.age = age;
    }

    public Client(int id, String name, String email, BigInteger phone, String about, int age) {
        this(name, email, phone, about, age);
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, about, age);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Client other = (Client) obj;

        return id == other.id &&
                (name == null && other.name == null ||
                        name != null && other.name != null && name.equals(other.name)) &&
                (email == null && other.email == null ||
                        email != null && other.email != null && email.equals(other.email)) &&
                phone == other.phone &&
                (about == null && other.about == null ||
                        about != null && other.about != null && about.equals(other.about)) &&
                age == other.age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", phone=" + phone +
                ", about=" + about +
                ", age=" + age +
                "}";
    }
}
