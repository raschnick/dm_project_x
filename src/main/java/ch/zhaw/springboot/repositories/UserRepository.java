package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Permission;
import ch.zhaw.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("SELECT user FROM user WHERE user.name = ?1")
    User findUserByName(String name);*/

}
