package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import halimProject.halimProject.entities.Students;



public interface IStudentsServices {
	Students saveStudents(Students p) throws IOException;
	List<Students> getAllStudents();
	Students getStudents (int id);
	public Students updateStudents(Students students) throws IOException;
	public void deleteStudents(int idStudents);
	Students getStudentsByName (String name);
}
