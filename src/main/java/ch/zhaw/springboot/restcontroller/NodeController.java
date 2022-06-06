package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Node;
import ch.zhaw.springboot.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class NodeController {

    @Autowired
    private NodeRepository repository;

    @RequestMapping(value = "/nodes", method = RequestMethod.GET)
    public ResponseEntity<List<Node>> getNodes() {
        List<Node> result = this.repository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<List<Node>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Node>>(result, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/nodes/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Node>> getNodeById(@PathVariable("id") Long id) {
        List<Node> result = this.repository.findAllById(Collections.singleton(id));

        if (!result.isEmpty()) {
            return new ResponseEntity<List<Node>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Node>>(HttpStatus.NOT_FOUND);
        }
    }

}
