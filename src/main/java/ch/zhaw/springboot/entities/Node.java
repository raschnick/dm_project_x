package ch.zhaw.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", discriminatorType = DiscriminatorType.STRING)
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "node_id")
    private List<Permission> permissions;

    @ManyToOne
    private Folder folder;

    public Node(String name) {
        this.name = name;
    }

    public Node() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: is this required? what does it again?
    @JsonIgnore
    public List<Permission> getPermissions() {
        return permissions;
    }

}
