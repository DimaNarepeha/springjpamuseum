package ua.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "technique")
public class Technique {
    @Id
    @Column(name = "id_technique")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "technique_name", unique = true)
    String technique_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnique_name() {
        return technique_name;
    }


    public void setTechnique_name(String technique_name) {
        this.technique_name = technique_name;
    }

    @Override
    public String toString() {
        return technique_name;
    }
}
