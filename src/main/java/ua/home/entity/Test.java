package ua.home.entity;


import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
    public class Test {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        @Column

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
