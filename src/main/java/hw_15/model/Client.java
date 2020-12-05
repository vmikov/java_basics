package hw_15.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "clients", schema = "javaelementary")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Account> accounts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_status",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<Status> statuses;

    @OneToOne(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private IdentityCode identityCode;

    public Client() {}

    public Client(String name, String email, long phone, String about, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.age = age;
    }

    public Client(int id, String name, String email, long phone, String about, int age) {
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
                ", accounts=" + accounts.size() +
                ", statuses=" + statuses.size() +
                ", identity_code=" + identityCode.getCode() +
                "}";
    }

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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    public IdentityCode getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(IdentityCode identityCode) {
        this.identityCode = identityCode;
    }
}
