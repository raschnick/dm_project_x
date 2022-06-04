package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
