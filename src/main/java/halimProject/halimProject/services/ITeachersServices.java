package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import halimProject.halimProject.entities.Groups;
import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.Teachers;

public interface ITeachersServices {
	Teachers saveTeachers(Teachers p) throws IOException;
	List<Teachers> getAllTeachers();
	Teachers getTeachers (int id);
	public Teachers updateTeachers(Teachers Teachers) throws IOException;
	public void deleteTeachers(int idTeachers);
	Teachers getTeachersByName (String name);
}
