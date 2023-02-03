package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import halimProject.halimProject.dao.TeachersRepository;
import halimProject.halimProject.dao.carteEtudiantRepository;
import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.Teachers;
import halimProject.halimProject.entities.carteEtudiants;

@Service
public class TeachersServices implements ITeachersServices {
	public TeachersServices(TeachersRepository pr) {
		super();
		this.pr = pr;
	}
	TeachersRepository pr;
	@Override
	public Teachers saveTeachers(Teachers p) throws IOException {
		return pr.save(p);
	}

	@Override
	public List<Teachers> getAllTeachers() {
		return pr.findAll();
	}

	@Override
	public Teachers getTeachers(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public Teachers updateTeachers(Teachers Teachers) throws IOException {
		return this.pr.save(Teachers);
	}

	@Override
	public void deleteTeachers(int idTeachers) {
		Teachers Teachers =new Teachers();
		Teachers.setIdTeachers(idTeachers);
		this.pr.delete(Teachers);
		
	}

	@Override
	public Teachers getTeachersByName(String name) {
		return pr.findByName(name);
	}

}
