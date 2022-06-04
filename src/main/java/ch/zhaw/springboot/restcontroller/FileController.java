package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.File;
import ch.zhaw.springboot.entities.Permission;
import ch.zhaw.springboot.repositories.FileRepository;
import ch.zhaw.springboot.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileRepository repository;

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public ResponseEntity<List<File>> getFiles() {
        List<File> result = this.repository.findAll();

        File file = new File("exampleFile", "pdf");
        System.out.println("created file " + file);

        if (result.isEmpty()) {
            return new ResponseEntity<List<File>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<File>>(result, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<File>> getFileById(@PathVariable("id") Long id) {
        List<File> result = this.repository.findAllById(Collections.singleton(id));

        if (!result.isEmpty()) {
            return new ResponseEntity<List<File>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<File>>(HttpStatus.NOT_FOUND);
        }
    }

}
