package halimProject.halimProject.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.Teachers;
import halimProject.halimProject.services.StudentsServices;
import halimProject.halimProject.services.TeachersServices;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class teacherController {
	@Autowired
	TeachersServices sp;

	@GetMapping("/all")
	public ResponseEntity<?> getAllGroupsServices() {
		return ResponseEntity.ok(this.sp.getAllTeachers());
	}

	@PostMapping("/addteacher")
	public ResponseEntity<?> addTeacher(@ModelAttribute Teachers cd) throws IOException {

		Teachers cdd = this.sp.saveTeachers(cd);
		return ResponseEntity.ok(cdd);
	}

	@PutMapping("/updateTeachers")
	public ResponseEntity<?> updateStudents(@ModelAttribute Teachers Teachers) throws IOException {

		return ResponseEntity.ok(this.sp.updateTeachers(Teachers));
	}

	@DeleteMapping("/{idTeachers}")
	public void DelteStudents(@PathVariable("idTeachers)") int idTeachers) {
		this.sp.deleteTeachers(idTeachers);
	}

	@GetMapping("{qid}")
	public Teachers getSingleStudent(@PathVariable("qid") int qid) {
		System.out.println("Geettting single teacher");
		return this.sp.getTeachers(qid);
	}

	@GetMapping("/name/{name}")
	public Teachers getSinglecarteEtudiantsName(@PathVariable("name") String name) {
		return this.sp.getTeachersByName(name);
	}
}
