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

import halimProject.halimProject.entities.carteEtudiants;
import halimProject.halimProject.services.carteEtudiantsServices;

@RestController
@RequestMapping("/carte")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class carteEtudiantController {
    @Autowired
    carteEtudiantsServices sp;

    @GetMapping("/all")
    public ResponseEntity<?> getAllcarteEtudiants() {
        return ResponseEntity.ok(this.sp.getAllcarteEtudiants());
    }

    @PostMapping("/addcarte")
    public ResponseEntity<?> addCard(@ModelAttribute carteEtudiants cd, @RequestParam("file") MultipartFile mf)
            throws IOException {
        carteEtudiants cdd = this.sp.savecarteEtudiants(cd, mf);
        return ResponseEntity.ok(cdd);
    }

    @PutMapping("/updatecard")
    public ResponseEntity<?> updateCard(@ModelAttribute carteEtudiants carteEtudiants,
            @RequestParam("file") MultipartFile mf) throws IOException {

        return ResponseEntity.ok(this.sp.updatecarteEtudiants(carteEtudiants, mf));
    }

    @DeleteMapping("/{idcard}")
    public void Delte(@PathVariable("idcard") int idcard) {
        this.sp.deletecarteEtudiants(idcard);
    }

    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        String filenamee = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/" + filename;
        Resource file = sp.load(filenamee);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/{qid}")
    public carteEtudiants getSinglecarteEtudiants(@PathVariable("qid") int qid) {
        return this.sp.getcarteEtudiants(qid);
    }

    @GetMapping("/name/{name}") // not working
    public carteEtudiants getSinglecarteEtudiantsName(@PathVariable("name") String name) {
        return this.sp.getcarteEtudiantsByName(name);
    }
}
