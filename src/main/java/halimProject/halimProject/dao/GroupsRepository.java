package halimProject.halimProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import halimProject.halimProject.entities.Groups;
import halimProject.halimProject.entities.Students;

public interface GroupsRepository extends JpaRepository<Groups, Integer> {

}
