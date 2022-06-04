package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Permission;
import ch.zhaw.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
