package hw_15.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "identity_codes")
public class IdentityCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    private String code;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public IdentityCode() {}

    public IdentityCode (String code, Client client)
    {
        this.code = code;
        this.client = client;
    }

    public IdentityCode (int id, String code, Client client)
    {
        this(code, client);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
