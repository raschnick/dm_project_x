package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {

}
