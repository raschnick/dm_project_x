package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {

}
