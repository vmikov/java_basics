package hw_15.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="Accounts", schema = "javaelementary")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Account() {}

    public Account(Client client, String number, BigDecimal value) {
        this.client = client;
        this.number = number;
        this.value = value;
    }

    public Account(int id, Client client, String number, BigDecimal value) {
        this(client, number, value);
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "id=" + id +
                ", client=" + client +
                ", number=" + number +
                ", value=" + value +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client.getId(), number, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Account other = (Account) obj;
        return id == other.id &&
                client.getId() == other.getId() &&
                (number == null && other.number == null ||
                        number != null && other.number != null && number.equals(other.number)) &&
                (value == null && other.value == null ||
                        value != null && other.value != null && value.equals(other.value));
    }
}
