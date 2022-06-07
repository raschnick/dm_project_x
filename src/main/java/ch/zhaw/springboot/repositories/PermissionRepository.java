package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Permission;
import ch.zhaw.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("SELECT p1.user AS lhs, p2.user AS rhs FROM Permission p1, Permission p2 WHERE p1.node = p2.node AND p1.user < p2.user")
    List<Permission> getEdges();

    //SELECT p1.user_id AS lhs, p2.user_id AS rhs
    //FROM permission p1, permission p2
    //WHERE p1.node_id = p2.node_id
    //AND p1.user_id < p2.user_id;

}
