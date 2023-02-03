package halimProject.halimProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.carteEtudiants;


public interface carteEtudiantRepository extends JpaRepository<carteEtudiants, Integer> {
	carteEtudiants findByMatriculeStudent(String MatriculeStudent);
}
