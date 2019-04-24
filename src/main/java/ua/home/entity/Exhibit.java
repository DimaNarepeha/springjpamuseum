package ua.home.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exhibit")
public class Exhibit {
    @Id
    @Column(name = "id_exhibit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "exhibit_name")
    String exhibit_name;
    @ManyToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "author_exhibit",
            joinColumns = @JoinColumn(name = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_exhibit")
    )
    Set<Author> authors;


    @ManyToOne(cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "id_material")
    Material material;
    @ManyToOne(cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "id_technique")
    Technique technique;
    @ManyToOne(cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "id_hall")
    Hall hall;
    @ManyToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "exhibit_guide",
            joinColumns = @JoinColumn(name = "id_guide"),
            inverseJoinColumns = @JoinColumn(name = "id_exhibit"))

    Set<Guide> guides;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExhibit_name() {
        return exhibit_name;
    }

    public void setExhibit_name(String exhibit_name) {
        this.exhibit_name = exhibit_name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Guide> getGuides() {
        return guides;
    }

    public void setGuides(Set<Guide> guides) {
        this.guides = guides;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "id=" + id +
                ", exhibit_name='" + exhibit_name + '\'' +
                ", authors=" + authors +
                ", material=" + material +
                ", technique=" + technique +
                ", hall=" + hall +
                ", guides=" + guides +
                '}';
    }

}
