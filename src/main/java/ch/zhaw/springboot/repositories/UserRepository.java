package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user.id, user.name FROM User user")
    List<User> findUsersAsGraphNodes();

}
