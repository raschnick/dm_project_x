package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.User;
import ch.zhaw.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> result = this.repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<User>>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<User>> getUserById(@PathVariable("id") Long id) {
        List<User> result = this.repository.findAllById(Collections.singleton(id));

        if (!result.isEmpty()) {
            return new ResponseEntity<List<User>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/graph_nodes")
    public ResponseEntity<List<User>> getUsersAsGraphNodes() {
        List<User> result = this.repository.findUsersAsGraphNodes();

        if (result.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<User>>(result, HttpStatus.OK);
        }
    }

}
