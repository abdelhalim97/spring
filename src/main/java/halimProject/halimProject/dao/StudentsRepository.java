package halimProject.halimProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import halimProject.halimProject.entities.Students;



public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
