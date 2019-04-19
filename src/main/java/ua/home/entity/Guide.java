package ua.home.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="guide")

public class Guide implements Serializable {

    @Id
    @Column(name = "id_guide")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_guide;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    public int getId() {
        return id_guide;
    }

    public void setId(int id) {
        this.id_guide = id;
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
}
