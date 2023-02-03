package halimProject.halimProject.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halimProject.halimProject.dao.GroupsRepository;
import halimProject.halimProject.entities.Groups;
import halimProject.halimProject.entities.Students;
import halimProject.halimProject.entities.Teachers;

@Service
public class GroupsServices implements IGroupsServices {
	@Autowired
	GroupsRepository pr;
	@Override
	public Groups saveGroups(Groups p) throws IOException {
		// TODO Auto-generated method stub
		return pr.save(p);
	}

	@Override
	public List<Groups> getAllGroups() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Groups getGroups(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public Groups updateGroups(Groups Groups) throws IOException {
		// TODO Auto-generated method stub
		return this.pr.save(Groups);
	}

	@Override
	public void deleteGroups(int idGroups) {
		Groups Groups =new Groups();
		Groups.setIdGroup(idGroups);
		this.pr.delete(Groups);
		
	}

	@Override
	public Groups getGroupsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
