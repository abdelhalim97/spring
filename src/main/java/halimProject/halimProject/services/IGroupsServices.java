package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import halimProject.halimProject.entities.Groups;
import halimProject.halimProject.entities.Students;

public interface IGroupsServices {
	Groups saveGroups(Groups p) throws IOException;
	List<Groups> getAllGroups();
	Groups getGroups (int id);
	public Groups updateGroups(Groups Groups) throws IOException;
	public void deleteGroups(int idGroups);
	Groups getGroupsByName (String name);
}
