package hw_4.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {
    private String id;
    private String name;
    private String account;
    private BigDecimal sum;

    public Client() {}

    public Client(String id, String name, String account, BigDecimal sum) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(account, client.account) &&
                Objects.equals(sum, client.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, account, sum);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "id=" + id +
                ", name=" + name +
                ", account=" + account +
                ", sum=" + sum +
                "}";
    }
}
