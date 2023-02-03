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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import halimProject.halimProject.entities.Groups;
import halimProject.halimProject.entities.Students;
import halimProject.halimProject.services.GroupsServices;
import halimProject.halimProject.services.StudentsServices;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class studentController {
	@Autowired
	StudentsServices sp;

	@GetMapping("/all")
	public ResponseEntity<?> getAllGroupsServices() {
		return ResponseEntity.ok(this.sp.getAllStudents());
	}

	@PostMapping("/addgroups")
	public ResponseEntity<?> addStudents(@ModelAttribute Students cd) throws IOException {

		Students cdd = this.sp.saveStudents(cd);
		return ResponseEntity.ok(cdd);
	}

	@PutMapping("/updateStudents")
	public ResponseEntity<?> updateStudents(@ModelAttribute Students Students) throws IOException {

		return ResponseEntity.ok(this.sp.updateStudents(Students));
	}

	@DeleteMapping("/{idStudents}")
	public void DelteStudents(@PathVariable("idStudents") int idStudents) {
		this.sp.deleteStudents(idStudents);
	}

	@GetMapping("{qid}")
	public Students getSingleStudent(@PathVariable("qid") int qid) {
		return this.sp.getStudents(qid);
	}

	@GetMapping("/name/{name}")
	public Students getSinglecarteEtudiantsName(@PathVariable("name") String name) {
		return this.sp.getStudentsByName(name);
	}
}
