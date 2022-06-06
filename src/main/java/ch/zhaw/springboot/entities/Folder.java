package ch.zhaw.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@DiscriminatorValue("folder")
public class Folder extends Node {

    private Integer size;

    @OneToMany
    @JoinColumn(name = "folder_id")
    private List<Node> nodes;

    public Folder(String name, Integer size) {
        super(name);
        this.size = size;
    }

    public Folder() {
        super();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    // TODO: is this required? what does it again?
    @JsonIgnore
    public List<Node> getNodes() {
        return nodes;
    }

}
