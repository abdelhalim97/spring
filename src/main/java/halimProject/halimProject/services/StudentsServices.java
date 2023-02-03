package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halimProject.halimProject.dao.StudentsRepository;
import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.Teachers;

@Service
public class StudentsServices implements IStudentsServices {
@Autowired
StudentsRepository pr;

	@Override
	public Students saveStudents(Students p) throws IOException {
		// TODO Auto-generated method stub
		return pr.save(p);
	}

	@Override
	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Students getStudents(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public Students updateStudents(Students students) throws IOException {
		// TODO Auto-generated method stub
		return this.pr.save(students);
	}

	@Override
	public void deleteStudents(int idStudents) {
		// TODO Auto-generated method stub
		Students Students =new Students();
		Students.setIdStudent(idStudents);
		this.pr.delete(Students);
	}

	@Override
	public Students getStudentsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
