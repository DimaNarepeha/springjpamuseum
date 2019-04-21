package ua.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @Column(name = "id_material")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "material_name", unique = true)
    String material_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    @Override
    public String toString() {
        return  material_name;
    }
}
