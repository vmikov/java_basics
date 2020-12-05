package hw_15.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "statuses", schema = "javaelementary")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alias;
    private String description;

    public Status () {}

    public Status (String alias, String description) {
        this.alias = alias;
        this.description = description;
    }
    public Status (int id, String alias, String description){
        this(alias, description);
        this.id = id;
    }

    @ManyToMany(mappedBy = "statuses")
    private Set<Client> clients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alias, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Status other = (Status) obj;

        return id == other.id &&
                (alias == null && other.alias == null ||
                        alias != null && other.alias != null && alias.equals(other.alias)) &&
                (description == null && other.description == null ||
                        description != null && other.description != null && description.equals(other.description));
    }

    @Override
    public String toString() {
        return "Status{id=" + id +
                ", alias=" + alias +
                ", description=" + description + "}";
    }
}
