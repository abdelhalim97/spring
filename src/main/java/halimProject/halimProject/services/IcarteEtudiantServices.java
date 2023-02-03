package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import halimProject.halimProject.entities.carteEtudiants;


public interface IcarteEtudiantServices {
	carteEtudiants savecarteEtudiants(carteEtudiants p,MultipartFile mf) throws IOException;
	List<carteEtudiants> getAllcarteEtudiants();
	carteEtudiants getcarteEtudiants (int id);
	public carteEtudiants updatecarteEtudiants(carteEtudiants carteEtudiants,MultipartFile mf) throws IOException;
	public void deletecarteEtudiants(int idcarteEtudiants);
	String saveImage(MultipartFile mf)throws IOException ;
	void supprimerImage(Integer idcarteEtudiants) throws IOException;
	public Resource load(String filename);
	carteEtudiants getcarteEtudiantsByName (String name);
}
