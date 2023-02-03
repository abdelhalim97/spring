package halimProject.halimProject.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import halimProject.halimProject.dao.carteEtudiantRepository;
import halimProject.halimProject.entities.carteEtudiants;

@Service
public class carteEtudiantsServices implements IcarteEtudiantServices {

	public carteEtudiantsServices(carteEtudiantRepository pr) {
		super();
		this.pr = pr;
	}

	carteEtudiantRepository pr;

	@Override
	public carteEtudiants savecarteEtudiants(carteEtudiants p, MultipartFile mf) throws IOException {
		String photo;
		if (!mf.getOriginalFilename().equals("")) {
			photo = saveImage(mf);
			p.setImage(photo);
		}
		return pr.save(p);
	}

	@Override
	public List<carteEtudiants> getAllcarteEtudiants() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public carteEtudiants getcarteEtudiants(int id) {
		return pr.findById(id).get();
	}

	@Override
	public carteEtudiants updatecarteEtudiants(carteEtudiants carteEtudiants, MultipartFile mf) throws IOException {
		String photo;
		if (!mf.getOriginalFilename().equals("")) {
			photo = saveImage(mf);
			carteEtudiants.setImage(photo);
		}
		return this.pr.save(carteEtudiants);
	}

	@Override
	public void deletecarteEtudiants(int idcarteEtudiants) {
		carteEtudiants carteEtudiants = new carteEtudiants();
		carteEtudiants.setId(idcarteEtudiants);
		this.pr.delete(carteEtudiants);

	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		String nameFile = mf.getOriginalFilename();
		String tab[] = nameFile.split("\\.");
		String fileModif = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];

		String chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin, fileModif);
		Files.write(p, mf.getBytes());
		System.out.println(chemin);
		return fileModif;
	}

	@Override
	public void supprimerImage(Integer idcarteEtudiants) throws IOException {
		carteEtudiants carteEtudiants = pr.getById(idcarteEtudiants);

		/*
		 * String chemin = System.getProperty("user.dir")+
		 * "/src/main/webapp/imagesdata";
		 * Path p = Paths.get(chemin,pokemon.getImage());
		 * System.out.println(p);
		 * Files.delete(p);
		 */

	}

	private final Path root = Paths.get("uploads");

	@Override
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@Override
	public carteEtudiants getcarteEtudiantsByName(String name) {
		return pr.findByMatriculeStudent(name);
	}

}
