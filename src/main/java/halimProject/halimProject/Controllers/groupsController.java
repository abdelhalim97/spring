package halimProject.halimProject.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import halimProject.halimProject.entities.Groups;
import halimProject.halimProject.entities.carteEtudiants;
import halimProject.halimProject.services.GroupsServices;
import halimProject.halimProject.services.carteEtudiantsServices;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class groupsController {
	@Autowired
	GroupsServices sp;

	@GetMapping("/all")
	public ResponseEntity<?> getAllGroupsServices() {
		return ResponseEntity.ok(this.sp.getAllGroups());
	}

	@PostMapping("/addgroups")
	public ResponseEntity<?> addCard(@ModelAttribute Groups cd) throws IOException {

		Groups cdd = this.sp.saveGroups(cd);
		return ResponseEntity.ok(cdd);
	}

	@PutMapping("/updategroups")
	public ResponseEntity<?> updategroups(@ModelAttribute Groups Groups) throws IOException {

		return ResponseEntity.ok(this.sp.updateGroups(Groups));
	}

	@DeleteMapping("/{idgroups}")
	public void DelteGroups(@PathVariable("idgroups") int idgroups) {
		this.sp.deleteGroups(idgroups);
	}

	@GetMapping("/{qid}")
	public Groups getSingleGroup(@PathVariable("qid") int qid) {
		return this.sp.getGroups(qid);
	}

	@GetMapping("/name/{name}")
	public Groups getSinglecarteEtudiantsName(@PathVariable("name") String name) {
		return this.sp.getGroupsByName(name);
	}

}
