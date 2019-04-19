package ua.home.entity;


import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
    public class Test implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        @Column(name = "number")
        private Integer number;
    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
