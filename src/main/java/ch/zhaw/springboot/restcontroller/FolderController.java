package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Folder;
import ch.zhaw.springboot.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class FolderController {

    @Autowired
    private FolderRepository repository;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getFiles() {
        List<Folder> result = this.repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<List<Folder>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Folder>>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity<List<Folder>> getFolderById(@PathVariable("id") Long id) {
        List<Folder> result = this.repository.findAllById(Collections.singleton(id));

        if (!result.isEmpty()) {
            return new ResponseEntity<List<Folder>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Folder>>(HttpStatus.NOT_FOUND);
        }
    }

}
