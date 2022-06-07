package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Permission;
import ch.zhaw.springboot.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class PermissionController {

    @Autowired
    private PermissionRepository repository;

    @GetMapping("/permissions")
    public ResponseEntity<List<Permission>> getPermissions() {
        List<Permission> result = this.repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<List<Permission>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Permission>>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/permissions/{id}")
    public ResponseEntity<List<Permission>> getPermissionById(@PathVariable("id") Long id) {
        List<Permission> result = this.repository.findAllById(Collections.singleton(id));

        if (!result.isEmpty()) {
            return new ResponseEntity<List<Permission>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Permission>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("permissions/edges")
    public ResponseEntity<List<Permission>> getEdges() {
        List<Permission> result = this.repository.getEdges();

        if (result.isEmpty()) {
            return new ResponseEntity<List<Permission>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Permission>>(result, HttpStatus.OK);
        }
    }

}
