package hw_13.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private int id;
    private String number;
    private BigDecimal value;
    private int clientId;

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

    public Account(int clientId, String number, BigDecimal value) {
        this.clientId = clientId;
        this.number = number;
        this.value = value;
    }

    public Account(int id, int clientId, String number, BigDecimal value) {
        this(clientId, number, value);
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number=" + number +
                ", value=" + value +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, number, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Account other = (Account) obj;
        return id == other.id &&
                clientId == other.clientId &&
                (number == null && other.number == null ||
                        number != null && other.number != null && number.equals(other.number)) &&
                (value == null && other.value == null ||
                        value != null && other.value != null && value.equals(other.value));
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
