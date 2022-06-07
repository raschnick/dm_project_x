package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.File;
import ch.zhaw.springboot.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileRepository repository;

    @GetMapping("/files")
    public ResponseEntity<List<File>> getFiles() {
        List<File> result = this.repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<List<File>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<File>>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<List<File>> getFileById(@PathVariable("id") Long id) {
        List<File> result = this.repository.findAllById(Collections.singleton(id));

        if (!result.isEmpty()) {
            return new ResponseEntity<List<File>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<File>>(HttpStatus.NOT_FOUND);
        }
    }

}
