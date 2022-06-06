package ch.zhaw.springboot.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("file")
public class File extends Node {

    private String fileType;

    public File(String name, String fileType) {
        super(name);
        this.fileType = fileType;
    }

    public File() {
        super();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
