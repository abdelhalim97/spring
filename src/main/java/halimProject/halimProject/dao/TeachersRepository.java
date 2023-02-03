package halimProject.halimProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.Teachers;


public interface TeachersRepository extends JpaRepository<Teachers, Integer> {
	Teachers findByName(String name);
}
