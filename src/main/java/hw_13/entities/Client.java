package hw_13.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Client {
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}
